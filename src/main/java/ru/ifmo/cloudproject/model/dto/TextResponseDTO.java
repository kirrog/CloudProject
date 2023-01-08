package ru.ifmo.cloudproject.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TextResponseDTO {
    private int code;
    private String text;
}
