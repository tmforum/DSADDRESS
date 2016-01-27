package org.tmf.dsmapi.streetSegment.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface StreetSegmentRESTEventPublisherLocal {

    public void publish(Hub hub, StreetSegmentEvent event);
    
}
