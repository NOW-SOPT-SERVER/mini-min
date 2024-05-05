package org.sopt.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    public static Post create(String title, String content, Blog blog) {
        return Post.builder()
                .title(title)
                .content(content)
                .blog(blog)
                .build();
    }

    @Builder
    public Post(String title, String content, Blog blog) {
        this.title = title;
        this.content = content;
        this.blog = blog;
    }
}
