package com.centroweg.escola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "aluno")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "nome", nullable = false)
        private String nome;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "matricula", nullable = false)
        private String matricula;

        @Column(name = "data_nascimento", nullable = false)
        private Date dataNascimento;


        public Aluno(String nome, String email, String matricula, Date dataNascimento) {
            this.nome = nome;
            this.email = email;
            this.matricula = matricula;
            this.dataNascimento = dataNascimento;
        }

    /*
    public Aluno(long id, String nome, String email, String matricula, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }*/
}


