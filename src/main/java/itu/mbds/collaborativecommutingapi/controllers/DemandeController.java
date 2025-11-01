package itu.mbds.collaborativecommutingapi.controllers;

import java.util.List;

import itu.mbds.collaborativecommutingapi.dtos.TrajetConducteurDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeRequestDTO;
import itu.mbds.collaborativecommutingapi.dtos.demande.DemandeResponseDTO;
import itu.mbds.collaborativecommutingapi.entities.Demande;
import itu.mbds.collaborativecommutingapi.services.demande.IDemandeService;
import itu.mbds.collaborativecommutingapi.services.match.IMatchingService;
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
    private final IMatchingService matchingService;

    @Autowired
    public DemandeController(IDemandeService demandeService, IMatchingService matchingService) {
        this.demandeService = demandeService;
        this.matchingService = matchingService;
    }

    // Création d’une demande
    @PostMapping
    public ResponseEntity<DemandeResponseDTO> create(@Valid @RequestBody DemandeRequestDTO dto) {
        return ResponseEntity.ok(demandeService.create(dto));
    }

    // Récupération d’une demande par ID
    @GetMapping("/{id}")
    public ResponseEntity<DemandeResponseDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(demandeService.getById(id));
    }

    // Récupération de toutes les demandes
    @GetMapping
    public ResponseEntity<List<DemandeResponseDTO>> getAll() {
        return ResponseEntity.ok(demandeService.getAll());
    }

    // Suppression d’une demande par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        demandeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Récupération d'un match
    @GetMapping("/match/{id}")
    public ResponseEntity<List<TrajetConducteurDTO>> matchDemandes(@PathVariable String id) {
        // On récupère la demande depuis la DB
        DemandeResponseDTO demandeDTO = demandeService.getById(id); // méthode à créer dans ton service pour renvoyer l'entité complète

        // On récupère les conducteurs matchés
        List<TrajetConducteurDTO> conducteursMatch = matchingService.matchConducteurs(demandeDTO);

        return ResponseEntity.ok(conducteursMatch);
    }
}
