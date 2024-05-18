package org.sopt.demo.common.dto;

public record SuccessStatusResponse(
        int status,
        String message
) {
    public static SuccessStatusResponse of(SucceessMessage successMessage) {
        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }
}
