package org.tmf.dsmapi.subAddress.event;

public enum SubAddressEventTypeEnum {

    SubAddressCreationNotification("SubAddressCreationNotification"),
    SubAddressUpdateNotification("SubAddressUpdateNotification"),
    SubAddressDeletionNotification("SubAddressDeletionNotification"),
    SubAddressValueChangeNotification("SubAddressValueChangeNotification"),
    SubAddressStatusChangedNotification("SubAddressStatusChangedNotification");

    private String text;

    SubAddressEventTypeEnum(String text) {
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
    public static SubAddressEventTypeEnum fromString(String text) {
        if (text != null) {
            for (SubAddressEventTypeEnum b : SubAddressEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }

}