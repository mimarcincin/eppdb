package sk.upjs.eppdb.controller;

import sk.upjs.eppdb.EppdbApplication;
import sk.upjs.eppdb.exception.ResourceNotFoundException;
import sk.upjs.eppdb.model.Plant;
import sk.upjs.eppdb.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
public class PlantController {

    @Autowired
    PlantRepository plantRepository;

    @GetMapping("/plants")
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @PostMapping("/plants")
    public Plant createPlant(@Valid @RequestBody Plant plant) {
        return plantRepository.save(plant);
    }

    @GetMapping("/plant/{id}")
    public Plant getPlantById(@PathVariable(value = "id") Long plantId) {
        return plantRepository.findById(plantId)
                .orElseThrow(() -> new ResourceNotFoundException("Plant", "id", plantId));
    }

    @PutMapping("/plants/{id}")
    public Plant updatePlant(@PathVariable(value = "id") Long plantId,
                                           @Valid @RequestBody Plant plantDetails) {

        Plant plant = plantRepository.findById(plantId)
                .orElseThrow(() -> new ResourceNotFoundException("Plant", "id", plantId));

        plant.setFamily(plantDetails.getFamily());
        plant.setGenus(plantDetails.getGenus());
        plant.setSpecies(plantDetails.getSpecies());
        plant.setAuthority(plantDetails.getAuthority());
        plant.setNotice(plantDetails.getNotice());

        Plant updatedPlant = plantRepository.save(plant);
        return updatedPlant;
    }

    @DeleteMapping("/plants/{id}")
    public ResponseEntity<?> deletePlant(@PathVariable(value = "id") Long plantId) {
        Plant plant= plantRepository.findById(plantId)
                .orElseThrow(() -> new ResourceNotFoundException("plant", "id", plantId));

        plantRepository.delete(plant);

        return ResponseEntity.ok().build();
    }
    public static void main(String[] args) {
    /*	PlantController pc = new PlantController();
		Plant p = new Plant();
		p.setFamily("family");
		p.setGenus("genus");
		p.setSpecies("species");
		p.setAuthority("authority");
		pc.createPlant(p);
		
*/
	} 
}
