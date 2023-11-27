package br.gereaulas.controller;

import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gereaulas.model.Responsible;
import br.gereaulas.repository.ResponsibleRepository;

@RestController
@RequestMapping("/responsibles")
public class ResponsibleController {

    @Autowired
    private ResponsibleRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Responsible>> getAllResponsibles() {
        Iterable<Responsible> responsibles = repository.findAll();
        return ResponseEntity.ok(responsibles);
    }

    @PostMapping
    public ResponseEntity<Responsible> createResponsible(@RequestBody Responsible newResponsible) {
        Responsible savedResponsible = repository.save(newResponsible);
        return new ResponseEntity<>(savedResponsible, HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Responsible> getResponsibleByEmail(@PathVariable String email) {
        Responsible responsible = repository.findByEmail(email).get(0);

        if (responsible != null) {
            return ResponseEntity.ok(responsible);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
