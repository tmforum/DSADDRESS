package org.tmf.dsmapi.subAddress.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.address.model.SubAddress;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class SubAddressEventPublisher implements SubAddressEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    SubAddressEventFacade eventFacade;
    @EJB
    SubAddressRESTEventPublisherLocal restEventPublisherLocal;

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
    public void publish(SubAddressEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(SubAddressEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(SubAddress bean, Date date) {
        SubAddressEvent event = new SubAddressEvent();
        event.setEventTime(date);
        event.setEventType(SubAddressEventTypeEnum.SubAddressCreationNotification);
        event.setResource(bean);
        publish(event);

    }

    @Override
    public void deletionNotification(SubAddress bean, Date date) {
        SubAddressEvent event = new SubAddressEvent();
        event.setEventTime(date);
        event.setEventType(SubAddressEventTypeEnum.SubAddressDeletionNotification);
        event.setResource(bean);
        publish(event);
    }
	
    @Override
    public void updateNotification(SubAddress bean, Date date) {
        SubAddressEvent event = new SubAddressEvent();
        event.setEventTime(date);
        event.setEventType(SubAddressEventTypeEnum.SubAddressUpdateNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void valueChangedNotification(SubAddress bean, Date date) {
        SubAddressEvent event = new SubAddressEvent();
        event.setEventTime(date);
        event.setEventType(SubAddressEventTypeEnum.SubAddressValueChangeNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void statusChangedNotification(SubAddress bean, Date date) {
        SubAddressEvent event = new SubAddressEvent();
        event.setEventTime(date);
        event.setEventType(SubAddressEventTypeEnum.SubAddressStatusChangedNotification);
        event.setResource(bean);
        publish(event);
    }

}
