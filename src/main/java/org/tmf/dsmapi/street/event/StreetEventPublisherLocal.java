package org.tmf.dsmapi.street.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.address.model.Street;


@Local
public interface StreetEventPublisherLocal {

    void publish(StreetEvent event);

    /**
     *
     * CreateNotification
     * @param bean the bean which has been created
     * @param date the creation date
     */
    public void createNotification(Street bean, Date date);

    /**
     *
     * DeletionNotification
     * @param bean the bean which has been deleted
     * @param date the deletion date
     */
    public void deletionNotification(Street bean, Date date);

    /**
     *
     * UpdateNotification (PATCH)
     * @param bean the bean which has been updated
     * @param date the update date
     */
    public void updateNotification(Street bean, Date date);

    /**
     *
     * ValueChangeNotification
     * @param bean the bean which has been changed
     * @param date the change date
     */
    public void valueChangedNotification(Street bean, Date date);

    public void statusChangedNotification(Street bean, Date date);

}
