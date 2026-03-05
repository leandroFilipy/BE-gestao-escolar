package com.centroweg.escola.repository;

import com.centroweg.escola.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT DISTINCT t.professor FROM Turma t WHERE t.curso.id = :cursoId")
    public List<Professor> findProfessor(@Param("cursoId") Long id);

}
