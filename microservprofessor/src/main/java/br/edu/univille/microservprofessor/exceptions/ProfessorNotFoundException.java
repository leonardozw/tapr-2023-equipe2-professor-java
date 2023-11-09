package br.edu.univille.microservprofessor.exceptions;

public class ProfessorNotFoundException extends RuntimeException{
    public ProfessorNotFoundException(){
        super("O professor não foi encontrado!");
    }
}
