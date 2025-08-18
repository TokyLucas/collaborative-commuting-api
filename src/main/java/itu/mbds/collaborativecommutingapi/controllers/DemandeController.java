package itu.mbds.collaborativecommutingapi.controllers;

import java.util.List;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeRequestDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;
import itu.mbds.collaborativecommutingapi.services.demande.IDemandeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {

    private final IDemandeService demandeService;

    @Autowired
    public DemandeController(IDemandeService demandeService) {
        this.demandeService = demandeService;
    }

    // ➡️ Création d’une demande
    @PostMapping
    public ResponseEntity<DemandeResponseDTO> create(@Valid @RequestBody DemandeRequestDTO dto) {
        return ResponseEntity.ok(demandeService.create(dto));
    }

    // ➡️ Récupération d’une demande par ID
    @GetMapping("/{id}")
    public ResponseEntity<DemandeResponseDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(demandeService.getById(id));
    }

    // ➡️ Récupération de toutes les demandes
    @GetMapping
    public ResponseEntity<List<DemandeResponseDTO>> getAll() {
        return ResponseEntity.ok(demandeService.getAll());
    }

    // ➡️ Suppression d’une demande par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        demandeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ➡️ Récupération des conducteurs qui matchent une demande
    /*@GetMapping("/{id}/match")
    public ResponseEntity<?> matchDemandes(@PathVariable String id) {
        return ResponseEntity.ok(demandeService.matchDemandes(id));
    }*/
}
