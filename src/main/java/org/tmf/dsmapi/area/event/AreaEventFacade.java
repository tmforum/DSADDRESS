package org.tmf.dsmapi.area.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class AreaEventFacade extends AbstractFacade<AreaEvent>{
    
    @PersistenceContext(unitName = "DSAddressPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public AreaEventFacade() {
        super(AreaEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
