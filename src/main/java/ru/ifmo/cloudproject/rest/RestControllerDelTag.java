package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.DelTagRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;

@RestController
@RequestMapping(path = "/del/tag")
@RequiredArgsConstructor
public class RestControllerDelTag {
    @DeleteMapping
    public ResponseEntity<TextResponseDTO> delTagByName(@RequestBody DelTagRequestDTO delTagRequestDTO) {
        return ResponseEntity.ok(TextResponseDTO.builder().text("text").code(0).build());
    }
}
