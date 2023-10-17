package br.edu.univille.microservprofessor.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.univille.microservprofessor.entity.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String>{
    
}
