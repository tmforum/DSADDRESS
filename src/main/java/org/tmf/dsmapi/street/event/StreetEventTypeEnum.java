package org.tmf.dsmapi.street.event;

public enum StreetEventTypeEnum {

    StreetCreationNotification("StreetCreationNotification"),
    StreetUpdateNotification("StreetUpdateNotification"),
    StreetDeletionNotification("StreetDeletionNotification"),
    StreetValueChangeNotification("StreetValueChangeNotification"),
    StreetStatusChangedNotification("StreetStatusChangedNotification");

    private String text;

    StreetEventTypeEnum(String text) {
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
    public static StreetEventTypeEnum fromString(String text) {
        if (text != null) {
            for (StreetEventTypeEnum b : StreetEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }

}