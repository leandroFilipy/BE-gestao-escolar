package com.centroweg.escola.repository;

import com.centroweg.escola.model.Aluno;
import com.centroweg.escola.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

    @Query(value = """
            SELECT a.* FROM aluno a
            JOIN turma_aluno ta ON ta.aluno_id = a.id
            WHERE ta.turma_id = :turmaId
            """,
            nativeQuery = true)
    List<Aluno> findAlunosByTurmaId(@Param("turmaId") Long turmaId);
}
