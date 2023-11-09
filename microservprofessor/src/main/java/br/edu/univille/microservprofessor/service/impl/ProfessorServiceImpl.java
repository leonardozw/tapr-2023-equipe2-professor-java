package br.edu.univille.microservprofessor.service.impl;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.azure.cosmos.models.PartitionKey;

import br.edu.univille.microservprofessor.controller.ProfessorUpdateRequest;
import br.edu.univille.microservprofessor.entity.Professor;
import br.edu.univille.microservprofessor.exceptions.ProfessorAlreadyExistsException;
import br.edu.univille.microservprofessor.exceptions.ProfessorNotFoundException;
import br.edu.univille.microservprofessor.repository.ProfessorRepository;
import br.edu.univille.microservprofessor.service.ProfessorService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService{
    
    private final ProfessorRepository professorRepository;

    public Professor createProfessor(Professor professor){
        if(professorRepository.existsByDocumento(professor.getDocumento())){
            throw new ProfessorAlreadyExistsException(professor.getDocumento());
        }
        professor.setCreatedAt(Instant.now());
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
        professorToBeUpdated.setNome(professor.nome());
        professorToBeUpdated.setCep(professor.cep());
        professorToBeUpdated.setTelefone(professor.telefone());
        professorToBeUpdated.setEmail(professor.email());
        professorToBeUpdated.setDataNascimento(professor.dataNascimento());
        professorToBeUpdated.setLastUpdatedAt(Instant.now());
        return professorRepository.save(professorToBeUpdated);
    }

    public void deleteProfessorById(String id, String key) {
        professorRepository.deleteById(id, new PartitionKey(key));
    }

}
