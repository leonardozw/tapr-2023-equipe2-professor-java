package br.edu.univille.microservprofessor.entity;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Container(containerName = "professor")
public class Professor {
    
    @Id
    @GeneratedValue
    private String id;

    private String nome;

    @PartitionKey
    private String documento;

    private String endereco;
    private Integer idade;
    
}
