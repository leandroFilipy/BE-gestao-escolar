package com.centroweg.escola.service;

import com.centroweg.escola.dto.TurmaRequest;
import com.centroweg.escola.dto.TurmaResponse;
import com.centroweg.escola.mapper.TurmaMapper;
import com.centroweg.escola.model.Aluno;
import com.centroweg.escola.model.Curso;
import com.centroweg.escola.model.Turma;
import com.centroweg.escola.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final TurmaMapper turmaMapper;

    public TurmaResponse criarTurma (TurmaRequest turmaRequest) throws SQLException{

        Turma turma = turmaMapper.paraEntidade(turmaRequest);
        Turma turma1 = turmaRepository.save(turma);


        return turmaMapper.paraDTO(turma1);
    }

    public List<TurmaResponse> listarTurmas () throws SQLException{

        List<Turma> turmas = turmaRepository.findAll();
        List<TurmaResponse> turmaResponses = new ArrayList<>();

        for(Turma t : turmas){
            turmaResponses.add(turmaMapper.paraDTO(t));
        }

        return turmaResponses;
    }

    public TurmaResponse listarTurmaPorId(long id)throws SQLException{

        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new RuntimeException("deu erro no service"));
        TurmaResponse turmaResponse = turmaMapper.paraDTO(turma);

        return turmaResponse;
    }

    public TurmaResponse atualizarTurma(long id, TurmaRequest turmaRequest) throws SQLException {
        Turma turmaExistente = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada no service"));

        Turma turmaAtualizada = turmaMapper.paraEntidade(turmaRequest);
        turmaAtualizada.setId(turmaExistente.getId());
        Turma turmaSalva = turmaRepository.save(turmaAtualizada);

        return turmaMapper.paraDTO(turmaSalva);
    }

    public void deletarTurmas (@PathVariable long id) throws SQLException{

        turmaRepository.deleteById(id);
    }

}
