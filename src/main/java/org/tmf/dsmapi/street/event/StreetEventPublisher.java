package org.tmf.dsmapi.street.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.address.model.Street;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class StreetEventPublisher implements StreetEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    StreetEventFacade eventFacade;
    @EJB
    StreetRESTEventPublisherLocal restEventPublisherLocal;

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
    public void publish(StreetEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(StreetEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(Street bean, Date date) {
        StreetEvent event = new StreetEvent();
        event.setEventTime(date);
        event.setEventType(StreetEventTypeEnum.StreetCreationNotification);
        event.setResource(bean);
        publish(event);

    }

    @Override
    public void deletionNotification(Street bean, Date date) {
        StreetEvent event = new StreetEvent();
        event.setEventTime(date);
        event.setEventType(StreetEventTypeEnum.StreetDeletionNotification);
        event.setResource(bean);
        publish(event);
    }
	
    @Override
    public void updateNotification(Street bean, Date date) {
        StreetEvent event = new StreetEvent();
        event.setEventTime(date);
        event.setEventType(StreetEventTypeEnum.StreetUpdateNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void valueChangedNotification(Street bean, Date date) {
        StreetEvent event = new StreetEvent();
        event.setEventTime(date);
        event.setEventType(StreetEventTypeEnum.StreetValueChangeNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void statusChangedNotification(Street bean, Date date) {
        StreetEvent event = new StreetEvent();
        event.setEventTime(date);
        event.setEventType(StreetEventTypeEnum.StreetStatusChangedNotification);
        event.setResource(bean);
        publish(event);
    }

}
