package com.centroweg.escola.service;

import com.centroweg.escola.dto.AlunoRequest;
import com.centroweg.escola.dto.AlunoResponse;
import com.centroweg.escola.mapper.AlunoMapper;
import com.centroweg.escola.model.Aluno;
import com.centroweg.escola.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper;


    public AlunoResponse criarAluno(AlunoRequest alunoRequest)throws SQLException{

        Aluno aluno = alunoMapper.paraEntidade(alunoRequest);
        Aluno aluno1 = alunoRepository.save(aluno);
        AlunoResponse alunoResponse = alunoMapper.paraDto(aluno1);
        return alunoResponse;
    }

    public List<AlunoResponse> listarAlunos () throws SQLException{
        List<Aluno> alunos = alunoRepository.findAll();
        List<AlunoResponse> alunoResponses = new ArrayList<>();

        for(Aluno aluno : alunos){
            alunoResponses.add(alunoMapper.paraDto(aluno));
        }
        return alunoResponses;
    }

    public AlunoResponse listarAlunoPorId(long id)throws SQLException{
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não existe");
        }

        AlunoResponse alunoResponse = alunoMapper.paraDto(aluno.get());

        return alunoResponse;
    }

    @Transactional
    public AlunoResponse atualizarAluno(long id, AlunoRequest alunoRequest) throws SQLException{

        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(alunoRequest.nome());
        aluno.setEmail(alunoRequest.email());
        aluno.setMatricula(alunoRequest.matricula());
        aluno.setDataNascimento(alunoRequest.dataNascimento());

        Aluno aluno1 = alunoRepository.save(aluno);

        AlunoResponse alunoResponse = alunoMapper.paraDto(aluno1);

        return alunoResponse;
    }

    @Transactional
    public void removerAluno(long id) throws SQLException{

        alunoRepository.deleteById(id);
    }
}
