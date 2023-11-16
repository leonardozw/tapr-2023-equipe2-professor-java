package br.edu.univille.microservprofessor.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.azure.cosmos.models.PartitionKey;

import br.edu.univille.microservprofessor.controller.ProfessorUpdateRequest;
import br.edu.univille.microservprofessor.entity.Professor;
import br.edu.univille.microservprofessor.exceptions.ProfessorAlreadyExistsException;
import br.edu.univille.microservprofessor.exceptions.ProfessorNotFoundException;
import br.edu.univille.microservprofessor.repository.ProfessorRepository;
import br.edu.univille.microservprofessor.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{
    
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor createProfessor(Professor professor){
        if(professorRepository.existsByDocumento(professor.getDocumento())){
            throw new ProfessorAlreadyExistsException(professor.getDocumento());
        }
        professor.setCreatedAt(LocalDateTime.now());
        return professorRepository.save(professor);
    }

    public Professor getProfessorById(String id){
        return professorRepository.findById(id).orElseThrow(ProfessorNotFoundException::new);
    }

    public Professor getProfessorByDocumento(String documento){
        return professorRepository.findByDocumento(documento).orElseThrow(ProfessorNotFoundException::new);
    }

    public List<Professor> getAllProfessores(){
        return professorRepository.findAll();
    }

    public Professor updateProfessor(String id, ProfessorUpdateRequest professor) {
        var professorToBeUpdated = professorRepository.findById(id).orElseThrow(RuntimeException::new);
        if(professor.nome() != null){
            professorToBeUpdated.setNome(professor.nome());
        }
        if(professor.cep() != null){
            professorToBeUpdated.setCep(professor.cep());
        }
        if(professor.telefone() != null){
            professorToBeUpdated.setTelefone(professor.telefone());
        }
        if(professor.email() != null){
            professorToBeUpdated.setEmail(professor.email());
        }
        if(professor.dataNascimento() != null){
            professorToBeUpdated.setDataNascimento(professor.dataNascimento());
        }
        professorToBeUpdated.setLastUpdatedAt(LocalDateTime.now());
        return professorRepository.save(professorToBeUpdated);
    }

    public void deleteProfessorById(String id, String key) {
        professorRepository.deleteById(id, new PartitionKey(key));
    }

}
