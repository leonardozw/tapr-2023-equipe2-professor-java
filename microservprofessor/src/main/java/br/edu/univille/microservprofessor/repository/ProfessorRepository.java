package br.edu.univille.microservprofessor.repository;

import java.util.List;
import java.util.Optional;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import br.edu.univille.microservprofessor.entity.Professor;

public interface ProfessorRepository extends CosmosRepository<Professor, String>{

    List<Professor> findAll();
    Optional<Professor> findById(String id);
    Optional<Professor> findByDocumento(String documento);
    boolean existsByDocumento(String documento);
    void deleteByDocumento(String documento, String key);
}
