package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.AddDocRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.service.AddDocService;

@RestController
@RequestMapping(path = "/add/doc")
@RequiredArgsConstructor
public class RestControllerAddDoc {

    private final AddDocService addDocService;

    @PostMapping
    public ResponseEntity<TextResponseDTO> addDoc(@RequestBody AddDocRequestDTO addDocRequestDTO) {
        return ResponseEntity.ok(addDocService.addDoc(addDocRequestDTO));
    }
}
