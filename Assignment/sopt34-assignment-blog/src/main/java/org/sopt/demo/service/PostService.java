package org.sopt.demo.service;

import lombok.RequiredArgsConstructor;
import org.sopt.demo.domain.Blog;
import org.sopt.demo.domain.Member;
import org.sopt.demo.domain.Post;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.ForbiddenException;
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
            final Long memberId,
            final Long blogId,
            final BlogPostCreateRequest blogPostCreateRequest
    ) {
        Blog blog = blogService.findById(blogId);
        checkBlogOwner(memberId, blog);
        Post post = Post.create(blogPostCreateRequest.title(), blogPostCreateRequest.content(), blog);
        post = postRepository.save(post);
        return post.getId().toString();
    }

    private void checkBlogOwner(
            final Long memberId,
            final Blog blog
    ) {
        if (!blog.getMember().getId().equals(memberId)) {
            throw new ForbiddenException(ErrorMessage.POST_USER_FORBIDDEN);
        }
    }

    public PostFindResponse findPostById(
            final Long postId
    ) {
        Post post = findById(postId);
        return PostFindResponse.of(post);
    }

    public Post findById(
            final Long postId
    ) {
        return postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
        );
    }
}
