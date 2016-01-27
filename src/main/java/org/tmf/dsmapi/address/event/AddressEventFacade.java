package org.tmf.dsmapi.address.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class AddressEventFacade extends AbstractFacade<AddressEvent>{
    
    @PersistenceContext(unitName = "DSAddressPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public AddressEventFacade() {
        super(AddressEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
