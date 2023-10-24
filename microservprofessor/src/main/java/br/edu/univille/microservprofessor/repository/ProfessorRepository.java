package br.edu.univille.microservprofessor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.edu.univille.microservprofessor.entity.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String>{

    List<Professor> findAll();
    Optional<Professor> findByDocumento(String documento);
}
