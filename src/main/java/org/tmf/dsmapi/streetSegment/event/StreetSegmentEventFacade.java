package org.tmf.dsmapi.streetSegment.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class StreetSegmentEventFacade extends AbstractFacade<StreetSegmentEvent>{
    
    @PersistenceContext(unitName = "DSAddressPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public StreetSegmentEventFacade() {
        super(StreetSegmentEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
