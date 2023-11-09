package br.edu.univille.microservprofessor.controller;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfessorUpdateRequest(
    @NotBlank(message = "O nome é obrigatório.")
    String nome,

    @NotBlank(message = "O cep é obrigatório.")
    String cep,

    @NotBlank(message = "O telefone é obrigatório.")
    String telefone,

    @NotBlank(message = "O email é obrigatório.")
    String email,

    @NotNull(message = "A data de nascimento é obrigatória.")
    LocalDate dataNascimento
) {}
