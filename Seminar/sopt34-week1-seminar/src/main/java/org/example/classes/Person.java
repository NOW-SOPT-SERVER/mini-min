package org.example.classes;

import java.security.PublicKey;

public class Person {
    private String name;
    private int age;
    private String sex;

    // 생성자 : 인스턴스가 처음 생성될 때 호출되는 인스턴스 초기화 메서드
    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    // 생성자는 조건에 따라 여러개를 작성할 수도 있음
    public Person(String name, int age) {
        this(name, age, "i don't know");
    }

    // Getter : 객체의 필드값을 가져오는 메서드
    public String getName() {
        return this.name;
    }

    // Setter : 객체의 필드값을 변경해주는 메서드
    public void setName(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println("사람이 걷습니다.");
    }

    // static 메서드 : 객체 생성 여부와 상관없이 사용가능
    public static void run() {
        System.out.println("사람이 달립니다!!");
    }

    // 정적 팩토리 메서드 : static 메서드를 통해 간접적으로 생성자를 호출하는 객체를 생성
    public static Person create(String name, int age, String sex) {
        return new Person(name, age, sex);
    }
}
