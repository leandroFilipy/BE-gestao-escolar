package com.centroweg.escola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curso")
@Setter
@Getter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo", nullable = false)
    private String codigo;


    public Curso(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

}
