package org.tmf.dsmapi.address.event;

public enum AddressEventTypeEnum {

    AddressCreationNotification("AddressCreationNotification"),
    AddressUpdateNotification("AddressUpdateNotification"),
    AddressDeletionNotification("AddressDeletionNotification"),
    AddressValueChangeNotification("AddressValueChangeNotification"),
    AddressStatusChangedNotification("AddressStatusChangedNotification");

    private String text;

    AddressEventTypeEnum(String text) {
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
    public static AddressEventTypeEnum fromString(String text) {
        if (text != null) {
            for (AddressEventTypeEnum b : AddressEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }

}