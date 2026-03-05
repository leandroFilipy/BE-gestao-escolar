package com.centroweg.escola.controller;

import com.centroweg.escola.dto.TurmaRequest;
import com.centroweg.escola.dto.TurmaResponse;
import com.centroweg.escola.model.Turma;
import com.centroweg.escola.repository.TurmaRepository;
import com.centroweg.escola.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/turma")
public class TurmaController {

    private final TurmaService turmaService;
    private final TurmaRepository turmaRepository;

    @PostMapping
    public TurmaResponse criarTurma(@RequestBody TurmaRequest turmaRequest) {
        try{
            return turmaService.criarTurma(turmaRequest);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<TurmaResponse> listarTurma () throws SQLException{
        try{
            return turmaService.listarTurmas();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public TurmaResponse listarTurmaPorId(@PathVariable long id){
        try{
            return turmaService.listarTurmaPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public TurmaResponse atualizarTurma(@PathVariable long id, TurmaRequest turmaRequest){
        try{
            return turmaService.atualizarTurma(id, turmaRequest);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTurma(@PathVariable long id){
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro no controller"));
        return ResponseEntity.status(201).body("delete foi realizado com sucesso cujo o id da turma é: " + turma.getId());
    }

}
