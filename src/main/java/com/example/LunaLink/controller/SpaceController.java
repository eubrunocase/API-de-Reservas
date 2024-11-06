package com.example.LunaLink.controller;
import com.example.LunaLink.model.Space;
import com.example.LunaLink.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/space")
public class SpaceController {

    @Autowired
    private SpaceRepository spaceRepository;

    @PostMapping
    public ResponseEntity<Space> createSpace(@RequestBody Space space) {
        Space savedSpace = spaceRepository.save(space);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSpace);
    }

    @GetMapping
    public List<Space> getAllSpaces () {
        return spaceRepository.findAll();
    }
}
