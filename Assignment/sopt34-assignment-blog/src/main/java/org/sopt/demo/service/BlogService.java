package org.sopt.demo.service;

import lombok.RequiredArgsConstructor;
import org.sopt.demo.service.dto.request.BlogTitleUpdateRequest;
import org.sopt.demo.domain.Blog;
import org.sopt.demo.domain.Member;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.NotFoundException;
import org.sopt.demo.repository.BlogRepository;
import org.sopt.demo.service.dto.request.BlogCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String createBlog(Long memberId, BlogCreateRequest blogCreateRequest) {
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getMember().toString();
    }

    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = findBlogById(blogId);
        blog.updateTitle(blogTitleUpdateRequest.title());
    }

    public Blog findBlogById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND)
        );
    }
}
