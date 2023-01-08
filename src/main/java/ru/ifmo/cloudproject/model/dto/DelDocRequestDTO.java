package ru.ifmo.cloudproject.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DelDocRequestDTO {
    private String docId;
}
