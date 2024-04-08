package org.example.classes;

public class PersonBuilder {
    private String name;
    private int age;
    private String sex;

    // 각 필드를 설정해주는 메서드 (this를 return하면서 메서드 체이닝이 가능해진다)
    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }
    public PersonBuilder sex(String sex) {
        this.sex = sex;
        return this;
    }

    // PersonBuilder의 필드를 가지고 Person 클래스에 할당하여 Person 객체를 생성, 반환하는 메서드
    public Person build() {
        return new Person(name, age, sex);
    }
}
