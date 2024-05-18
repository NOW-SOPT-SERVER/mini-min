package org.sopt.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.demo.service.dto.request.BlogCreateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    private String imageUrl;

    public static Blog create(
            final Member member,
            BlogCreateRequest blogCreateRequest,
            String imageUrl
    ) {
        return Blog.builder()
                .member(member)
                .title(blogCreateRequest.title())
                .description(blogCreateRequest.description())
                .imageUrl(imageUrl)
                .build();
    }

    @Builder
    private Blog(Member member, String title, String description, String imageUrl) {
        this.member = member;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public void updateTitle(String title) {
        this.title = title;
    }
}
