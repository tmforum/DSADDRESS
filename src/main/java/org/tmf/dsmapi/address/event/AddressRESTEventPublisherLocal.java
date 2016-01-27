package org.tmf.dsmapi.address.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface AddressRESTEventPublisherLocal {

    public void publish(Hub hub, AddressEvent event);
    
}
