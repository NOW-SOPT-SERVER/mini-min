package org.example.classes;

// 추상 클래스 : 선언되어 있지만 구현되어 있지 않은 미완성 메서드(추상 메서드)를 포함한 미완성 클래스
public abstract class Animal {
    abstract public void walk();

    public void eat() {
        System.out.println("냠냠 맛이 좋네요");
    }
}
