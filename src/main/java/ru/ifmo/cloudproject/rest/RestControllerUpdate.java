package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.model.dto.UpdateDocRequestDTO;
import ru.ifmo.cloudproject.service.UpdateDocByIdService;

@RestController
@RequestMapping(path = "/update")
@RequiredArgsConstructor
public class RestControllerUpdate {
    private final UpdateDocByIdService updateDocByIdService;

    @PostMapping
    public ResponseEntity<TextResponseDTO> updateDocById(@RequestBody UpdateDocRequestDTO updateDocRequestDTO) {
        return ResponseEntity.ok(updateDocByIdService.updateDocById(updateDocRequestDTO));
    }
}
