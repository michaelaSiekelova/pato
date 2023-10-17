package cz.upol.pato.attributesmanagement.enums;

import cz.upol.pato.ticketmanagement.enums.TicketEnums;

import java.util.Arrays;
import java.util.List;

public enum AttributeType {

    STRING("attributeType.shortString"),
    DATE("attributeType.longString"),
    FLOAT("attributeType.integer");


    private String i18nKey;

    AttributeType(String i18nKey){
        this.i18nKey = i18nKey;
    }


}
