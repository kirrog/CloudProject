package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.model.dto.UpdateDocRequestDTO;

@RestController
@RequestMapping(path = "/update")
@RequiredArgsConstructor
public class RestControllerUpdate {
    @PostMapping
    public ResponseEntity<TextResponseDTO> updateDocTags(@RequestBody UpdateDocRequestDTO updateDocRequestDTO) {
        return ResponseEntity.ok(TextResponseDTO.builder().text("text").code(0).build());
    }
}
