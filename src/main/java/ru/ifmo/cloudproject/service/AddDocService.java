package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.AddDocRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;

@Service
@RequiredArgsConstructor
public class AddDocService {
    public TextResponseDTO addDoc(AddDocRequestDTO addDocRequestDTO) {
        return null;
    }

}
