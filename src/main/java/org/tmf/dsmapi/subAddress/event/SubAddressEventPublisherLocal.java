package org.tmf.dsmapi.subAddress.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.address.model.SubAddress;


@Local
public interface SubAddressEventPublisherLocal {

    void publish(SubAddressEvent event);

    /**
     *
     * CreateNotification
     * @param bean the bean which has been created
     * @param date the creation date
     */
    public void createNotification(SubAddress bean, Date date);

    /**
     *
     * DeletionNotification
     * @param bean the bean which has been deleted
     * @param date the deletion date
     */
    public void deletionNotification(SubAddress bean, Date date);

    /**
     *
     * UpdateNotification (PATCH)
     * @param bean the bean which has been updated
     * @param date the update date
     */
    public void updateNotification(SubAddress bean, Date date);

    /**
     *
     * ValueChangeNotification
     * @param bean the bean which has been changed
     * @param date the change date
     */
    public void valueChangedNotification(SubAddress bean, Date date);

    public void statusChangedNotification(SubAddress bean, Date date);

}
