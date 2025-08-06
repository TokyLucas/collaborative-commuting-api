package itu.mbds.collaborativecommutingapi.controllers;


import itu.mbds.collaborativecommutingapi.dtos.TrajetConducteurDTO;
import itu.mbds.collaborativecommutingapi.dtos.user.UserDTO;
import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;
import itu.mbds.collaborativecommutingapi.services.trajetConducteur.ITrajetConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trajetC")
public class TrajetConducteurController {
    private final ITrajetConducteurService service;

    @Autowired
    public TrajetConducteurController(ITrajetConducteurService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public TrajetConducteur create(@RequestBody TrajetConducteurDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<TrajetConducteur> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public TrajetConducteur getById(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
