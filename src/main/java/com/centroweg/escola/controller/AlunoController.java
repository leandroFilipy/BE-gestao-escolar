package com.centroweg.escola.controller;

import com.centroweg.escola.dto.AlunoRequest;
import com.centroweg.escola.dto.AlunoResponse;
import com.centroweg.escola.model.Aluno;
import com.centroweg.escola.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.processing.SQL;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public AlunoResponse criarAluno(@Valid @RequestBody AlunoRequest alunoRequest){
        try{
            return alunoService.criarAluno(alunoRequest);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<AlunoResponse> listarAlunos (){

        try{
            return alunoService.listarAlunos();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public AlunoResponse listarAlunoPorId(@PathVariable long id){

        try{
            return alunoService.listarAlunoPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizarAluno( @PathVariable long id, @RequestBody AlunoRequest aluno){
        try{
            return alunoService.atualizarAluno(id, aluno);
        }
        catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void removerUsuario (@PathVariable long id){
        try {
            alunoService.removerAluno(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
