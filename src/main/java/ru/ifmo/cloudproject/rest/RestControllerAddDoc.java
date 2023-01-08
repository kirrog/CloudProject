package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.AddDocRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;

@RestController
@RequestMapping(path = "/add/doc")
@RequiredArgsConstructor
public class RestControllerAddDoc {
    @PostMapping
    public ResponseEntity<TextResponseDTO> addDoc(@RequestBody AddDocRequestDTO addDocRequestDTO) {
        return ResponseEntity.ok(TextResponseDTO.builder().text("text").code(0).build());
    }
}
