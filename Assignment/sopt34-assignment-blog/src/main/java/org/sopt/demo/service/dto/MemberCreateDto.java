package org.sopt.demo.service.dto;

import org.sopt.demo.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age) {
}
