package br.edu.univille.microservprofessor.controller;

import java.time.LocalDate;

public record ProfessorUpdateRequest(
    String nome,
    String cep,
    String telefone,
    String email,
    LocalDate dataNascimento
) {}
