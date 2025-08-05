package itu.mbds.collaborativecommutingapi.controllers;

import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteDTO;
import itu.mbds.collaborativecommutingapi.dtos.disponibilite.DisponibiliteRequestDTO;
import itu.mbds.collaborativecommutingapi.enums.DisponibiliteStatut;
import itu.mbds.collaborativecommutingapi.services.disponibilite.IDisponibiliteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilites")
public class DisponibiliteController {
    private final IDisponibiliteService service;

    @Autowired
    public DisponibiliteController(IDisponibiliteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DisponibiliteDTO> create(@Valid @RequestBody DisponibiliteRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/position/{conducteurId}")
    public ResponseEntity<DisponibiliteDTO> updatePosition(
            @PathVariable String conducteurId,
            @Valid @RequestBody DisponibiliteRequestDTO dto) {
        return ResponseEntity.ok(service.updatePosition(conducteurId, dto));
    }

    @PutMapping("/statut/{conducteurId}")
    public ResponseEntity<DisponibiliteDTO> updateStatut(
            @PathVariable String conducteurId,
            @RequestParam DisponibiliteStatut statut) {
        return ResponseEntity.ok(service.updateStatut(conducteurId, statut));
    }

    @GetMapping("/nearby")
    public ResponseEntity<List<DisponibiliteDTO>> findNearby(
            @RequestParam double lng,
            @RequestParam double lat,
            @RequestParam double radiusMeters) {
        Point p = new Point(lng, lat);
        Distance d = new Distance(radiusMeters / 1000.0, Metrics.KILOMETERS);
        return ResponseEntity.ok(service.findNearby(p, d));
    }
}
