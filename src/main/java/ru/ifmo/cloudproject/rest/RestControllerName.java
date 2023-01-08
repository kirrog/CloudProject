package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.DocIdDTO;
import ru.ifmo.cloudproject.service.FindDocsByNameService;

import java.util.List;

@RestController
@RequestMapping(path = "/name")
@RequiredArgsConstructor
public class RestControllerName {
    private final FindDocsByNameService findDocsByNameService;
    @GetMapping
    public ResponseEntity<List<DocIdDTO>> findDocsByName(@RequestParam String name) {
        return ResponseEntity.ok(findDocsByNameService.findDocsByName(name));
    }
}
