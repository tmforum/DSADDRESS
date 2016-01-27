package org.tmf.dsmapi.streetSegment.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.address.model.StreetSegment;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class StreetSegmentEventPublisher implements StreetSegmentEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    StreetSegmentEventFacade eventFacade;
    @EJB
    StreetSegmentRESTEventPublisherLocal restEventPublisherLocal;

    /** 
     * Add business logic below. (Right-click in editor and choose
     * "Insert Code > Add Business Method")
     * Access Hubs using callbacks and send to http publisher 
     *(pool should be configured around the RESTEventPublisher bean)
     * Loop into array of Hubs
     * Call RestEventPublisher - Need to implement resend policy plus eviction
     * Filtering is done in RestEventPublisher based on query expression
    */ 
    @Override
    public void publish(StreetSegmentEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(StreetSegmentEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(StreetSegment bean, Date date) {
        StreetSegmentEvent event = new StreetSegmentEvent();
        event.setEventTime(date);
        event.setEventType(StreetSegmentEventTypeEnum.StreetSegmentCreationNotification);
        event.setResource(bean);
        publish(event);

    }

    @Override
    public void deletionNotification(StreetSegment bean, Date date) {
        StreetSegmentEvent event = new StreetSegmentEvent();
        event.setEventTime(date);
        event.setEventType(StreetSegmentEventTypeEnum.StreetSegmentDeletionNotification);
        event.setResource(bean);
        publish(event);
    }
	
    @Override
    public void updateNotification(StreetSegment bean, Date date) {
        StreetSegmentEvent event = new StreetSegmentEvent();
        event.setEventTime(date);
        event.setEventType(StreetSegmentEventTypeEnum.StreetSegmentUpdateNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void valueChangedNotification(StreetSegment bean, Date date) {
        StreetSegmentEvent event = new StreetSegmentEvent();
        event.setEventTime(date);
        event.setEventType(StreetSegmentEventTypeEnum.StreetSegmentValueChangeNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void statusChangedNotification(StreetSegment bean, Date date) {
        StreetSegmentEvent event = new StreetSegmentEvent();
        event.setEventTime(date);
        event.setEventType(StreetSegmentEventTypeEnum.StreetSegmentStatusChangedNotification);
        event.setResource(bean);
        publish(event);
    }

}
