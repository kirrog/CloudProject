package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.DelDocRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;

@Service
@RequiredArgsConstructor
public class DelDocService {
    public TextResponseDTO delDocByDocId(DelDocRequestDTO delDocRequestDTO) {
        return null;
    }
}
