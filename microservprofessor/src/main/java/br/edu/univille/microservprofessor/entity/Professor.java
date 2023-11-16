package br.edu.univille.microservprofessor.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Container(containerName = "professor")
public class Professor {
    
    @Id
    @GeneratedValue
    private String id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @PartitionKey
    @NotBlank(message = "O documento é obrigatório.")
    private String documento;

    @NotBlank(message = "O cep é obrigatório.")
    private String cep;

    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

    @NotBlank(message = "O email é obrigatório.")
    private String email;

    @NotNull(message = "A data de Nascimento é obrigatória.")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataNascimento;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdatedAt;
}
