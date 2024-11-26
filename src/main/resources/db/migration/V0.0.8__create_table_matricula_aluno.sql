CREATE TABLE matricula_aluno (
                                 id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                 grade1 DOUBLE PRECISION,
                                 grade2 DOUBLE PRECISION,
                                 student_id UUID NOT NULL,
                                 subject_id UUID NOT NULL,
                                 status VARCHAR(50) NOT NULL,
                                 CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES aluno(id) ON DELETE CASCADE,
                                 CONSTRAINT fk_subject FOREIGN KEY (subject_id) REFERENCES disciplina(id) ON DELETE CASCADE
);