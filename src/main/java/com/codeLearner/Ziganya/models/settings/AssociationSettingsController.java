package com.codeLearner.Ziganya.models.settings;

import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/association-settings")
public class AssociationSettingsController {


    private final AssociationSettingsService associationSettingsService;

    public AssociationSettingsController(AssociationSettingsService associationSettingsService) {
        this.associationSettingsService = associationSettingsService;
    }

    @PostMapping
    public ResponseEntity<AssociationSettingsResponse> createAssociationSettings(@RequestBody AssociationSettingsRequest request){
        AssociationSettingsResponse response = associationSettingsService.createAssociationSettings(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AssociationSettingsResponse>> getAssociationSettings(){
        List<AssociationSettingsResponse> response = associationSettingsService.findAllAssociationSettings();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AssociationSettingsResponse> updateAssociationSettings(@PathVariable Long id, @RequestBody AssociationSettingsRequest request){
        AssociationSettingsResponse response = associationSettingsService.updateAssociationSettings(id, request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOperationResponse> delete(@PathVariable("id") Long id){
        DeleteOperationResponse response = associationSettingsService.deleteAssociationSettings(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
