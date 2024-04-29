package org.sopt.demo.service;

import lombok.RequiredArgsConstructor;
import org.sopt.demo.domain.Blog;
import org.sopt.demo.domain.Member;
import org.sopt.demo.domain.Post;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.NotFoundException;
import org.sopt.demo.repository.PostRepository;
import org.sopt.demo.service.dto.request.BlogPostCreateRequest;
import org.sopt.demo.service.dto.response.PostFindResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberService memberService;
    private final BlogService blogService;

    @Transactional
    public String createBlogPost(
            Long memberId,
            Long blogId,
            BlogPostCreateRequest blogPostCreateRequest
    ) {
        Member member = memberService.findById(memberId);
        Blog blog = blogService.findBlogById(blogId);

        Post post = Post.create(blogPostCreateRequest.title(), blogPostCreateRequest.content(), blog);
        post = postRepository.save(post);
        return post.getId().toString();
    }

    public PostFindResponse findPostById(
            Long postId
    ) {
        return PostFindResponse.of(postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
        ));
    }
}
