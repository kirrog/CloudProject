package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.AddTagRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.service.AddTagService;

@RestController
@RequestMapping(path = "/add/tag")
@RequiredArgsConstructor
public class RestControllerAddTag {
    private final AddTagService addTagService;
    @PostMapping
    public ResponseEntity<TextResponseDTO> addTagToDoc(@RequestBody AddTagRequestDTO addTagRequestDTO) {
        return ResponseEntity.ok(addTagService.addTagToDoc(addTagRequestDTO));
    }
}
