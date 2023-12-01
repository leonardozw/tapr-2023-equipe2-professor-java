package br.edu.univille.microservprofessor.repository;

import java.util.List;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import br.edu.univille.microservprofessor.entity.Disciplina;

public interface DisciplinaRepository extends CosmosRepository<Disciplina, String>{
    List<Disciplina> findAll();
}
