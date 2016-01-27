package org.tmf.dsmapi.area.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.address.model.Area;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class AreaEventPublisher implements AreaEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    AreaEventFacade eventFacade;
    @EJB
    AreaRESTEventPublisherLocal restEventPublisherLocal;

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
    public void publish(AreaEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(AreaEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(Area bean, Date date) {
        AreaEvent event = new AreaEvent();
        event.setEventTime(date);
        event.setEventType(AreaEventTypeEnum.AreaCreationNotification);
        event.setResource(bean);
        publish(event);

    }

    @Override
    public void deletionNotification(Area bean, Date date) {
        AreaEvent event = new AreaEvent();
        event.setEventTime(date);
        event.setEventType(AreaEventTypeEnum.AreaDeletionNotification);
        event.setResource(bean);
        publish(event);
    }
	
    @Override
    public void updateNotification(Area bean, Date date) {
        AreaEvent event = new AreaEvent();
        event.setEventTime(date);
        event.setEventType(AreaEventTypeEnum.AreaUpdateNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void valueChangedNotification(Area bean, Date date) {
        AreaEvent event = new AreaEvent();
        event.setEventTime(date);
        event.setEventType(AreaEventTypeEnum.AreaValueChangeNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void statusChangedNotification(Area bean, Date date) {
        AreaEvent event = new AreaEvent();
        event.setEventTime(date);
        event.setEventType(AreaEventTypeEnum.AreaStatusChangedNotification);
        event.setResource(bean);
        publish(event);
    }

}
