package org.tmf.dsmapi.subAddress.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class SubAddressEventFacade extends AbstractFacade<SubAddressEvent>{
    
    @PersistenceContext(unitName = "DSAddressPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public SubAddressEventFacade() {
        super(SubAddressEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
