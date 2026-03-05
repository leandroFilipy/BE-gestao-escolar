package com.centroweg.escola.service;

import com.centroweg.escola.dto.CursoRequest;
import com.centroweg.escola.dto.CursoResponse;
import com.centroweg.escola.mapper.CursosMapper;
import com.centroweg.escola.model.Curso;
import com.centroweg.escola.model.Professor;
import com.centroweg.escola.repository.CursoRepository;
import com.centroweg.escola.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursosMapper cursosMapper;
    private final ProfessorRepository professorRepository;


    public CursoResponse criarCurso(CursoRequest cursoRequest)throws SQLException{

        Curso curso = cursosMapper.paraEntidade(cursoRequest);
        Curso curso1 = cursoRepository.save(curso);

        List<Professor> professorList = professorRepository.findProfessor(curso.getId());

        List<String> nomes = new ArrayList<>();
        for(Professor p : professorList){
            nomes.add(p.getNome());
        }


        return cursosMapper.paraDTO(curso1,nomes);
    }

    public List<CursoResponse> listarCursos () throws SQLException{

        List<Curso> cursos = cursoRepository.findAll();
        List<CursoResponse> cursoResponses = new ArrayList<>();

        for (Curso curso : cursos){
            List<Professor> professorList = professorRepository.findProfessor(curso.getId());

            List<String> nomes = professorList.stream()
                    .map(Professor::getNome)
                    .toList();

            cursoResponses.add(cursosMapper.paraDTO(curso, nomes));
        }

        return cursoResponses;
    }

    public CursoResponse listarCursoPorId(long id)throws SQLException{

        Curso curso = cursoRepository.findById(id).orElseThrow();

        List<Professor> professorList = professorRepository.findProfessor(curso.getId());

        List<String> nomes = professorList.stream()
                .map(Professor::getNome)
                .toList();

        CursoResponse cursoResponse = cursosMapper.paraDTO(curso, nomes);

        return cursoResponse;
    }

    public CursoResponse atualizarCurso (long id, CursoRequest cursoRequest) throws SQLException{

        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Não encontrado um curso com este id"));

        curso.setNome(cursoRequest.nome());
        curso.setCodigo(cursoRequest.codigo());

        List<Professor> professorList = new ArrayList<>();

        List<String> nomes = professorList.stream()
                .map(Professor::getNome)
                .toList();

        Curso curso1 = cursoRepository.save(curso);
        CursoResponse cursoResponse = cursosMapper.paraDTO(curso1,nomes);

        return cursoResponse;
    }

    public void deletarCurso (long id) throws SQLException{

        Curso curso = cursoRepository.findById(id).orElseThrow();

        cursoRepository.deleteById(id);
    }

}
