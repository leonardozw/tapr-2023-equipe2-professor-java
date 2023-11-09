package br.edu.univille.microservprofessor.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.microservprofessor.entity.Professor;
import br.edu.univille.microservprofessor.service.impl.ProfessorServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/professores")
public class ProfessorAPIController {

    private final ProfessorServiceImpl service;

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody @Valid Professor professor){
        Professor savedProfessor = service.createProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProfessor);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable String id){
        Professor foundProfessor = service.getProfessorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(foundProfessor);
    }

    @GetMapping("/documento/{documento}")
    public ResponseEntity<Professor> getProfessorByDocumento(@PathVariable String documento){
        Professor foundProfessor = service.getProfessorByDocumento(documento);
        return ResponseEntity.status(HttpStatus.OK).body(foundProfessor);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessores(){
        List<Professor> list = service.getAllProfessores();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable String id, @RequestBody @Valid ProfessorUpdateRequest professor){
        Professor updatedProfessor = service.updateProfessor(id, professor);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProfessor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProfessorById(@PathVariable String id){
        Professor professor = service.getProfessorById(id);
        service.deleteProfessorById(id, professor.getDocumento());
        return ResponseEntity.noContent().build();
    }
}
