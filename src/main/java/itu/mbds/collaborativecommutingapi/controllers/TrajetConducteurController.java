package itu.mbds.collaborativecommutingapi.controllers;

import itu.mbds.collaborativecommutingapi.dtos.TrajetConducteurDTO;
import itu.mbds.collaborativecommutingapi.models.TrajetConducteur;
import itu.mbds.collaborativecommutingapi.models.TrajetVoitureView;
import itu.mbds.collaborativecommutingapi.services.TrajetVoiture.ITrajetVoitureService;
import itu.mbds.collaborativecommutingapi.services.trajetConducteur.ITrajetConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trajetC")
public class TrajetConducteurController {
    private final ITrajetConducteurService service;
    private final ITrajetVoitureService serviceV;


    @Autowired
    public TrajetConducteurController(ITrajetConducteurService service, ITrajetVoitureService serviceV) {
        this.service = service;
        this.serviceV = serviceV;
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
    @PreAuthorize("isAuthenticated()")
    public TrajetConducteur getById(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public TrajetConducteur update(@PathVariable String id, @RequestBody TrajetConducteurDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/conducteur/{conducteurId}")
    @PreAuthorize("isAuthenticated()")
    public List<TrajetConducteurDTO> getByConducteur(@PathVariable String conducteurId) {
        return service.getByIdConducteur(conducteurId);
    }

    @GetMapping("/getAll")
    @PreAuthorize("isAuthenticated()")
    public List<TrajetVoitureView> getAllTV() {
        return serviceV.getAll();
    }
}
