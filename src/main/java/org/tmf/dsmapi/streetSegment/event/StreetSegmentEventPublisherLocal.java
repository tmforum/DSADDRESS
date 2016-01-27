package org.tmf.dsmapi.streetSegment.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.address.model.StreetSegment;


@Local
public interface StreetSegmentEventPublisherLocal {

    void publish(StreetSegmentEvent event);

    /**
     *
     * CreateNotification
     * @param bean the bean which has been created
     * @param date the creation date
     */
    public void createNotification(StreetSegment bean, Date date);

    /**
     *
     * DeletionNotification
     * @param bean the bean which has been deleted
     * @param date the deletion date
     */
    public void deletionNotification(StreetSegment bean, Date date);

    /**
     *
     * UpdateNotification (PATCH)
     * @param bean the bean which has been updated
     * @param date the update date
     */
    public void updateNotification(StreetSegment bean, Date date);

    /**
     *
     * ValueChangeNotification
     * @param bean the bean which has been changed
     * @param date the change date
     */
    public void valueChangedNotification(StreetSegment bean, Date date);

    public void statusChangedNotification(StreetSegment bean, Date date);

}
