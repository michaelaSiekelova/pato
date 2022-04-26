package cz.upol.pato.permitsmanagement.enums;

import lombok.Getter;

@Getter
public enum Permits {

    CREATE_USER("permit.createUser");

    private String i18nKey;

    Permits(String i18nKey){
        this.i18nKey = i18nKey;
    }
}
