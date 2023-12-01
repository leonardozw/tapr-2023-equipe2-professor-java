package br.edu.univille.microservprofessor.service;

import java.util.List;

import br.edu.univille.microservprofessor.entity.Disciplina;

public interface DisciplinaService {
    public List<Disciplina> getAllDisciplinas();
    public Disciplina createDisciplina(Disciplina disciplina);
    public Disciplina getDisciplinaById(String id);
    public Disciplina updateDisciplina(String id, Disciplina disciplina);
    public Disciplina updateDisciplina(Disciplina disciplina);
}
