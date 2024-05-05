package org.sopt.demo.controller;

import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.sopt.demo.domain.enums.Part;
import org.sopt.demo.repository.MemberRepository;
import org.sopt.demo.service.MemberService;
import org.sopt.demo.service.dto.request.MemberCreateRequest;
import org.sopt.demo.settings.ApiTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class MemberControllerTest extends ApiTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Nested // 중첩 테스트를 진행할 수 있게하는 테스트
    @DisplayName("멤버 생성 테스트")
    public class CreateMember {

        @Test
        @DisplayName("요청 성공 케이스")
        public void createMemberSuccess() throws Exception {
            //given
            final var request = new MemberCreateRequest(
                    "민재리",
                    Part.IOS,
                    24);
            //when
            final var response = RestAssured
                    .given()
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(request)
                    .when()
                    .post("/api/v1/member")
                    .then().log().all().extract();
            //then
            Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        }

    }

}