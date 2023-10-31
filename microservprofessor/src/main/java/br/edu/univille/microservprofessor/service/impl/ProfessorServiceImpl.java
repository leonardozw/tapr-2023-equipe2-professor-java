package br.edu.univille.microservprofessor.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.univille.microservprofessor.entity.Professor;
import br.edu.univille.microservprofessor.repository.ProfessorRepository;
import br.edu.univille.microservprofessor.service.ProfessorService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService{
    
    private final ProfessorRepository professorRepository;

    public Professor createProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public Professor getProfessorById(String id){
        return professorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Professor getProfessorByDocumento(String documento){
        return professorRepository.findByDocumento(documento).orElseThrow(RuntimeException::new);
    }

    public List<Professor> getAllProfessores(){
        return professorRepository.findAll();
    }

    public Professor updateProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public void deleteProfessor(String id){
        professorRepository.deleteById(id);
    }

}
