package org.tmf.dsmapi.streetSegment.event;

public enum StreetSegmentEventTypeEnum {

    StreetSegmentCreationNotification("StreetSegmentCreationNotification"),
    StreetSegmentUpdateNotification("StreetSegmentUpdateNotification"),
    StreetSegmentDeletionNotification("StreetSegmentDeletionNotification"),
    StreetSegmentValueChangeNotification("StreetSegmentValueChangeNotification"),
    StreetSegmentStatusChangedNotification("StreetSegmentStatusChangedNotification");

    private String text;

    StreetSegmentEventTypeEnum(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return this.text;
    }

    /**
     *
     * @param text
     * @return
     */
    public static StreetSegmentEventTypeEnum fromString(String text) {
        if (text != null) {
            for (StreetSegmentEventTypeEnum b : StreetSegmentEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }

}