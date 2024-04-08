package org.example.classes;

public enum Part {

    SERVER("SERVER"),
    WEB("WEB"),
    IOS("IOS"),
    ANDROID("ANDROID"),
    DESIGN("DESIGN"),
    PLAN("PLAN"),
    ;

    public final String part;

    Part(String part) {
        this.part = part;
    }

    public String getPart() {
        return this.part;
    }
}
