package com.centroweg.escola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToOne(optional = false)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Turma(String nome, Curso curso, Professor professor) {
        this.nome = nome;
        this.curso = curso;
        this.professor = professor;
    }
}