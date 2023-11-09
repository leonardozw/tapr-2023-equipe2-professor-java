package br.edu.univille.microservprofessor.exceptions;

public class ProfessorAlreadyExistsException extends RuntimeException{
    public ProfessorAlreadyExistsException(String documento){
        super("O professor com documento " + documento + " já existe!");
    }
}
