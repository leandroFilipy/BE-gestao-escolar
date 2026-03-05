package com.centroweg.escola.repository;

import com.centroweg.escola.model.Curso;
import com.centroweg.escola.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
