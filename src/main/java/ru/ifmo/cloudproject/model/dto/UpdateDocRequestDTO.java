package ru.ifmo.cloudproject.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateDocRequestDTO {
    private String docId;
    private String text;
}
