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

    @ManyToMany
    private List<Professor> professores;


    public Curso(String nome, String codigo, List<Professor> professores) {
        this.nome = nome;
        this.codigo = codigo;
        this.professores = professores;
    }

}
