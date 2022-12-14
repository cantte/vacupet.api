package com.tic.vacupet.api.pets;

import com.tic.vacupet.pets.application.PetResponse;
import com.tic.vacupet.pets.application.add_vaccine.AddPetVaccineCommand;
import com.tic.vacupet.pets.application.create.CreatePetCommand;
import com.tic.vacupet.pets.application.search_all.SearchAllPetsQuery;
import io.jkratz.mediator.core.Mediator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin
public class PetController {

    private final Mediator mediator;

    public PetController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody CreatePetCommand command) {
        mediator.dispatch(command);

        return ResponseEntity.ok(true);
    }

    @GetMapping
    public ResponseEntity<List<PetResponse>> getAll() {
        var query = new SearchAllPetsQuery();
        var pets = mediator.dispatch(query);

        return ResponseEntity.ok(pets);
    }

    @PutMapping
    public ResponseEntity<Boolean> addVaccine(@RequestBody AddPetVaccineCommand command) {
        try {
            mediator.dispatch(command);

            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
