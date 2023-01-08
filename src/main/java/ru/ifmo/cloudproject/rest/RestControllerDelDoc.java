package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.DelDocRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.service.DelDocService;

@RestController
@RequestMapping(path = "/del/doc")
@RequiredArgsConstructor
public class RestControllerDelDoc {
    private final DelDocService delDocService;
    @DeleteMapping
    public ResponseEntity<TextResponseDTO> delDocByDocId(@RequestBody DelDocRequestDTO delDocRequestDTO) {
        return ResponseEntity.ok(delDocService.delDocByDocId(delDocRequestDTO));
    }
}
