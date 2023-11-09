package br.edu.univille.microservprofessor.service;

import java.util.List;

import br.edu.univille.microservprofessor.controller.ProfessorUpdateRequest;
import br.edu.univille.microservprofessor.entity.Professor;

public interface ProfessorService{
    
    public Professor createProfessor(Professor professor);
    public Professor getProfessorById(String id);
    public Professor getProfessorByDocumento(String documento);
    public List<Professor> getAllProfessores();
    public Professor updateProfessor(String id, ProfessorUpdateRequest professor);
    public void deleteProfessorById(String id, String key);
}
