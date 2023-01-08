package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.DocIdDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/tag")
@RequiredArgsConstructor
public class RestControllerTag {
    @GetMapping
    public ResponseEntity<List<DocIdDTO>> findDocsByTag(@RequestParam String tag) {
        return ResponseEntity.ok(List.of(DocIdDTO.builder().docId("1234").build()));
    }
}
