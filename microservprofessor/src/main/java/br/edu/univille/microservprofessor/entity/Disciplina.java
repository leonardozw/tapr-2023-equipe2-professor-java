package br.edu.univille.microservprofessor.entity;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import lombok.Getter;
import lombok.Setter;

@Container(containerName = "disciplina")
@Getter
@Setter
public class Disciplina {
    @Id
    @PartitionKey
    private String id;
    private int cargaHoraria;
    private int semestre;
}
