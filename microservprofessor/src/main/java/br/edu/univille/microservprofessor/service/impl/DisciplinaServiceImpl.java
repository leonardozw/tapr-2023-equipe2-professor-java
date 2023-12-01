package br.edu.univille.microservprofessor.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.univille.microservprofessor.entity.Disciplina;
import br.edu.univille.microservprofessor.repository.DisciplinaRepository;
import br.edu.univille.microservprofessor.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{
    private final DisciplinaRepository repository;

    public DisciplinaServiceImpl(DisciplinaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Disciplina createDisciplina(Disciplina disciplina) {
        disciplina.setId(null);
        return repository.save(disciplina);
    }

    @Override
    public List<Disciplina> getAllDisciplinas() {
        return repository.findAll();
    }

    @Override
    public Disciplina getDisciplinaById(String id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Disciplina updateDisciplina(String id, Disciplina disciplina) {
        Disciplina disc = repository.findById(id).orElseThrow(RuntimeException::new);
        disc.setSemestre(disciplina.getSemestre());
        disc.setCargaHoraria(disc.getCargaHoraria());
        return repository.save(disc);
    }

    @Override
    public Disciplina updateDisciplina(Disciplina disciplina) {
        return repository.save(disciplina);
    }
}
