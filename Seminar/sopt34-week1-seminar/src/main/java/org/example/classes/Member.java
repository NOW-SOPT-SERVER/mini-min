package org.example.classes;

public class Member extends Person {
    private Part part;

    public Member(String name, int age, String sex, Part part) {
        super(name, age, part);
        this.part = part;
    }
}
