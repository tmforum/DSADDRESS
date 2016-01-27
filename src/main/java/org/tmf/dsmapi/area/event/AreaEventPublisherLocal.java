package org.tmf.dsmapi.area.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.address.model.Area;


@Local
public interface AreaEventPublisherLocal {

    void publish(AreaEvent event);

    /**
     *
     * CreateNotification
     * @param bean the bean which has been created
     * @param date the creation date
     */
    public void createNotification(Area bean, Date date);

    /**
     *
     * DeletionNotification
     * @param bean the bean which has been deleted
     * @param date the deletion date
     */
    public void deletionNotification(Area bean, Date date);

    /**
     *
     * UpdateNotification (PATCH)
     * @param bean the bean which has been updated
     * @param date the update date
     */
    public void updateNotification(Area bean, Date date);

    /**
     *
     * ValueChangeNotification
     * @param bean the bean which has been changed
     * @param date the change date
     */
    public void valueChangedNotification(Area bean, Date date);

    public void statusChangedNotification(Area bean, Date date);

}
