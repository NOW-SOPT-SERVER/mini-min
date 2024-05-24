package org.sopt.demo.service;

import lombok.RequiredArgsConstructor;
import org.sopt.demo.external.S3Service;
import org.sopt.demo.service.dto.request.BlogTitleUpdateRequest;
import org.sopt.demo.domain.Blog;
import org.sopt.demo.domain.Member;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.NotFoundException;
import org.sopt.demo.repository.BlogRepository;
import org.sopt.demo.service.dto.request.BlogCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;
    private final S3Service s3Service;
    private static final String BLOG_S3_UPLOAD_FOLER = "blog/";

    public String createBlog(
            final Long memberId,
            final BlogCreateRequest blogCreateRequest
    ) {
        Member member = memberService.findById(memberId);
        try {
            Blog blog = blogRepository.save(
                    Blog.create(
                            member,
                            blogCreateRequest,
                            s3Service.uploadImage(BLOG_S3_UPLOAD_FOLER, blogCreateRequest.image())
                    )
            );
            return blog.getMember().toString();
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public void updateTitle(
            final Long blogId,
            final BlogTitleUpdateRequest blogTitleUpdateRequest
    ) {
        Blog blog = findById(blogId);
        blog.updateTitle(blogTitleUpdateRequest.title());
    }

    public Blog findById(
            final Long blogId
    ) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND)
        );
    }
}
