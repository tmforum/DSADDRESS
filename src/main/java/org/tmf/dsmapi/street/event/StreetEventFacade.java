package org.tmf.dsmapi.street.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class StreetEventFacade extends AbstractFacade<StreetEvent>{
    
    @PersistenceContext(unitName = "DSAddressPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public StreetEventFacade() {
        super(StreetEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
