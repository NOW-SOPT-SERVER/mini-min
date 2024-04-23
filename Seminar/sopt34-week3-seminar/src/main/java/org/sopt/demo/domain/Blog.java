package org.sopt.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.demo.service.dto.BlogCreateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    @Builder
    private Blog(Member member, String title, String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public static Blog create(final Member member, BlogCreateRequest blogCreateRequest) {
        return Blog.builder()
                .member(member)
                .title(blogCreateRequest.title())
                .description(blogCreateRequest.description())
                .build();
    }

    public void updateTitle(
            String title
    ) {
        this.title = title;
    }
}
