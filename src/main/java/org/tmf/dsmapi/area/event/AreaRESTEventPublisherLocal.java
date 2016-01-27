package org.tmf.dsmapi.area.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface AreaRESTEventPublisherLocal {

    public void publish(Hub hub, AreaEvent event);
    
}
