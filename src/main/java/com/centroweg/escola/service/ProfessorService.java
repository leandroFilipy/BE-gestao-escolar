package com.centroweg.escola.service;


import com.centroweg.escola.dto.ProfessorRequest;
import com.centroweg.escola.dto.ProfessorResponse;
import com.centroweg.escola.mapper.ProfessorMapper;
import com.centroweg.escola.model.Professor;
import com.centroweg.escola.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorResponse criarProfessor(Professor professor)throws SQLException{

        Professor professor1 = professorRepository.save(professor);
        ProfessorResponse professorResponse = professorMapper.paraDto(professor1);

        return professorResponse;
    }

    public List<ProfessorResponse> listarProfessor () throws SQLException{

        List<Professor> professores = professorRepository.findAll();
        List<ProfessorResponse> dtos = new ArrayList<>();

        for(Professor professor : professores){
            dtos.add(professorMapper.paraDto(professor));
        }
        return dtos;
    }

    public ProfessorResponse listarProfessorPorId(long id)throws SQLException{

        Optional<Professor> professor = professorRepository.findById(id);
        ProfessorResponse professorResponse = professorMapper.paraDto(professor.get());

        return professorResponse;
    }

    public ProfessorResponse atualizarProfessor(long id, ProfessorRequest professorRequest) throws SQLException{

        Professor professor = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Falha ao atualizar"));

        professor.setNome(professorRequest.nome());
        professor.setEmail(professorRequest.email());
        professor.setDisciplina(professorRequest.disciplina());
        Professor professor1 = professorRepository.save(professor);

        ProfessorResponse professorResponse = professorMapper.paraDto(professor);

        return professorResponse;
    }

}
