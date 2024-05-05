package org.sopt.demo.service.dto.request;

import org.sopt.demo.domain.enums.Part;

public record MemberCreateRequest(
        String name,
        Part part,
        int age
) {
}
