package org.example;

import org.example.classes.Person;
import org.example.classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {

        // 생성자를 이용해서 객체 생성
        Person person = new Person("이민재", 25, "male");
        person.walk();      // 일반 클래스 내 메서드 사용
        Person.run();       // run은 static 메서드이므로, person.run()으로 사용할 경우 에러발생

        // Getter와 Setter 적용
        System.out.println(person.getName());
        person.setName("민재리");
        System.out.println(person.getName());

        // 빌더 패턴으로 객체 생성
        Person personWithBuilder = new PersonBuilder()
                .name("홍길동")
                .age(100)
                .sex("female")
                .build();

        // 팩토리 메서드 패턴으로 객체 생성
        Person personWithFactoryMethod = Person.create("미니민", 1, "male");
    }
}