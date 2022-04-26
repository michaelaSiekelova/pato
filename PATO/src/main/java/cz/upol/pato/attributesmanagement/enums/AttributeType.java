package cz.upol.pato.attributesmanagement.enums;

public enum AttributeType {

    SHORT_STRING("attributeType.shortString"),
    LONG_STRING("attributeType.longString"),
    INTEGER("attributeType.integer"),
    BOOLEAN("attributeType.boolean"),
    FILE("attributeType.file");


    private String i18nKey;

    AttributeType(String i18nKey){
        this.i18nKey = i18nKey;
    }

}
