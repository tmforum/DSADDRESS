package org.tmf.dsmapi.address.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.address.model.Address;


@Local
public interface AddressEventPublisherLocal {

    void publish(AddressEvent event);

    /**
     *
     * CreateNotification
     * @param bean the bean which has been created
     * @param date the creation date
     */
    public void createNotification(Address bean, Date date);

    /**
     *
     * DeletionNotification
     * @param bean the bean which has been deleted
     * @param date the deletion date
     */
    public void deletionNotification(Address bean, Date date);

    /**
     *
     * UpdateNotification (PATCH)
     * @param bean the bean which has been updated
     * @param date the update date
     */
    public void updateNotification(Address bean, Date date);

    /**
     *
     * ValueChangeNotification
     * @param bean the bean which has been changed
     * @param date the change date
     */
    public void valueChangedNotification(Address bean, Date date);

    public void statusChangedNotification(Address bean, Date date);

}
