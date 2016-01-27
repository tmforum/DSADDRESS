package org.tmf.dsmapi.street.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface StreetRESTEventPublisherLocal {

    public void publish(Hub hub, StreetEvent event);
    
}
