package org.sopt.demo.repository;

import org.sopt.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository : JPA를 사용하여 데이터베이스를 조작하기 위한 메서드를 제공하는 어노테이션
// 복잡한 JDBC(Java DataBase Connectivity) 코드를 작성하지 않아도 간단하게 DB와의 데이터 접근 작업을 처리할 수 있음
public interface MemberRepository extends JpaRepository<Member, Long> {
}
