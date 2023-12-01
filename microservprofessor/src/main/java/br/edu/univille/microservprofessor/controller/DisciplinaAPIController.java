package br.edu.univille.microservprofessor.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.microservprofessor.entity.Disciplina;
import br.edu.univille.microservprofessor.service.DisciplinaService;
import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;


@RestController
@RequestMapping("api/v1/disciplinas")
public class DisciplinaAPIController {

    private final DisciplinaService service;

    public DisciplinaAPIController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> getAll(){
        List<Disciplina> list = service.getAllDisciplinas();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping
    public ResponseEntity<Disciplina> createDisciplina(@RequestBody Disciplina disciplina){
        Disciplina disc = service.createDisciplina(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(disc);
    }

    @Topic(name = "${app.component.topic.disciplina}", pubsubName = "${app.component.service}")
    @PostMapping(path = "/event", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Disciplina> atualizarCliente(@RequestBody(required = false) CloudEvent<Disciplina> cloudEvent){
        var disc = service.updateDisciplina(cloudEvent.getData());
        return new ResponseEntity<Disciplina>(disc, HttpStatus.OK);
    }
}
