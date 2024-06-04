package com.aluno_online.api.model;

import com.aluno_online.api.enums.MatriculaAlunoStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MatriculaAluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Double grade1;

    private Double grade2;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Aluno student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Disciplina subject;

    @Enumerated(EnumType.STRING)
    private MatriculaAlunoStatusEnum status;
}
