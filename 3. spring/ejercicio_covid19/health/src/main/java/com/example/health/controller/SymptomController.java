package com.example.health.controller;

import com.example.health.dto.request.symptom.GetSeverityByNameRequest;
import com.example.health.dto.response.person.GetRiskPersonsResponse;
import com.example.health.dto.response.symptom.GetSymptomsResponse;
import com.example.health.dto.response.symptom.GetSeverityByNameResponse;
import com.example.health.service.IPersonService;
import com.example.health.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SymptomController {
    private final IPersonService personService;
    private final ISymptomService symptomService;

    @Autowired
    public SymptomController(IPersonService personService,
                             ISymptomService symptomService){
        this.personService = personService;
        this.symptomService = symptomService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<GetSymptomsResponse> getSymptoms() {
        return ResponseEntity.ok(symptomService.getSymptoms());
    }

    @GetMapping("/findSymptomSeverity")  // /findSymptomSeverity?name=
    public ResponseEntity<GetSeverityByNameResponse> getSeverityByName(GetSeverityByNameRequest severityRequest) {
        return ResponseEntity.ok(symptomService.getSeverityByName(severityRequest.getName()));
    }

//    sino
//    @GetMapping("/findSymptom/{name}")
//    public ResponseEntity<GetSeverityResponse> getSeverity(@PathVariable("name") String name) {
//        return ResponseEntity.ok(symptomService.getSeverity(name));
//    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<GetRiskPersonsResponse> getRiskPersons() {
        return ResponseEntity.ok(personService.getRiskPersons());
    }
}
