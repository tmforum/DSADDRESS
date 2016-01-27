package org.tmf.dsmapi.address.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.address.model.Address;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class AddressEventPublisher implements AddressEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    AddressEventFacade eventFacade;
    @EJB
    AddressRESTEventPublisherLocal restEventPublisherLocal;

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
    public void publish(AddressEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(AddressEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(Address bean, Date date) {
        AddressEvent event = new AddressEvent();
        event.setEventTime(date);
        event.setEventType(AddressEventTypeEnum.AddressCreationNotification);
        event.setResource(bean);
        publish(event);

    }

    @Override
    public void deletionNotification(Address bean, Date date) {
        AddressEvent event = new AddressEvent();
        event.setEventTime(date);
        event.setEventType(AddressEventTypeEnum.AddressDeletionNotification);
        event.setResource(bean);
        publish(event);
    }
	
    @Override
    public void updateNotification(Address bean, Date date) {
        AddressEvent event = new AddressEvent();
        event.setEventTime(date);
        event.setEventType(AddressEventTypeEnum.AddressUpdateNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void valueChangedNotification(Address bean, Date date) {
        AddressEvent event = new AddressEvent();
        event.setEventTime(date);
        event.setEventType(AddressEventTypeEnum.AddressValueChangeNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void statusChangedNotification(Address bean, Date date) {
        AddressEvent event = new AddressEvent();
        event.setEventTime(date);
        event.setEventType(AddressEventTypeEnum.AddressStatusChangedNotification);
        event.setResource(bean);
        publish(event);
    }

}
