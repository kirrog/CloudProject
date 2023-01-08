package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.AddTagRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;

@RestController
@RequestMapping(path = "/add/tag")
@RequiredArgsConstructor
public class RestControllerAddTag {
    @PostMapping
    public ResponseEntity<TextResponseDTO> addTagToDoc(@RequestBody AddTagRequestDTO addTagRequestDTO) {
        return ResponseEntity.ok(TextResponseDTO.builder().text("text").code(0).build());
    }
}
