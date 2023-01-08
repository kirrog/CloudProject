package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.DelTagRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;

@Service
@RequiredArgsConstructor
public class DelTagService {
    public TextResponseDTO delTagByName(DelTagRequestDTO delTagRequestDTO) {
        return null;
    }
}
