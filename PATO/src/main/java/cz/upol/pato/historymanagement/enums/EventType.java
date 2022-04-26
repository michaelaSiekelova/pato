package cz.upol.pato.historymanagement.enums;

public enum EventType {

    CREATE_TICKET("eventType.createTicket"),
    ASSIGN_TICKET("eventType.assignTicket"),
    CHANGE_STATE("eventType.changeState"),
    NEW_ATTACHMENT("eventType.newAttachment");

    private String i18nKey;

    EventType(String i18nKey){
        this.i18nKey = i18nKey;
    }
}
