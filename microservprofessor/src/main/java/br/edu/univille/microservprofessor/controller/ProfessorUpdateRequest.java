package br.edu.univille.microservprofessor.controller;

public record ProfessorUpdateRequest(
    String nome,
    String cep,
    String telefone,
    String email
) {}
