package org.sopt.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity             // 객체와 테이블을 매핑, 해당 클래스는 JPA가 관리함
@NoArgsConstructor  // Lombok이 기본 생성자를 만들어줌 -> JPA가 엔티티 객체 생성시 기본 생성자를 사용하므로, 반드시 기본 생성자를 가져야함
@Getter             // Lombok이 전체 필드에 대한 Getter 함수를 정의해줌
public class Member {
    @Id     // 영속성 컨텍스트는 엔티티를 식별자 값으로 구분함. -> 엔티티를 영속 상태로 만들기 위해 식별자 값이 필. 테이블의 Primary Key와 연결
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Id만 사용하는 경우 기본키를 직접 할당해줘야함 -> 기본키를 직접 할당하는 대신 DB가 생성해주는 값을 사용하기 위해 붙임
    private Long id;    // id값은 직접 생성하는 것이 아니라 JPA가 생성 전략에 맞게 생성해줌 -> 생성자에 id 필드가 없어도 가능

    private String name;

    @Enumerated(EnumType.STRING)    // Java의 Enum 타입 매핑 때 사용함
    private Part part;

    private int age;

    // 1) 정적 팩토리 메서드 패턴으로 MemberEntity 생성하기
    public static Member create(String name, Part part, int age) {
        return Member.builder()
                .name(name)
                .part(part)
                .age(age)
                .build();
    }

    // 2) 빌더 패턴으로 MemberEntity 생성하기
    @Builder
    public Member(String name, Part part, int age) {
        this.name = name;
        this.part = part;
        this.age = age;
    }
}
