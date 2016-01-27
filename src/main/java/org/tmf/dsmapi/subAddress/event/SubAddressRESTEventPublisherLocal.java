package org.tmf.dsmapi.subAddress.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface SubAddressRESTEventPublisherLocal {

    public void publish(Hub hub, SubAddressEvent event);
    
}
