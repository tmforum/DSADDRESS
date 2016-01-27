package org.tmf.dsmapi.area.event;

public enum AreaEventTypeEnum {

    AreaCreationNotification("AreaCreationNotification"),
    AreaUpdateNotification("AreaUpdateNotification"),
    AreaDeletionNotification("AreaDeletionNotification"),
    AreaValueChangeNotification("AreaValueChangeNotification"),
    AreaStatusChangedNotification("AreaStatusChangedNotification");

    private String text;

    AreaEventTypeEnum(String text) {
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
    public static AreaEventTypeEnum fromString(String text) {
        if (text != null) {
            for (AreaEventTypeEnum b : AreaEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }

}