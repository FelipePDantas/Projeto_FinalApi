CREATE TABLE financeiro (
                            id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                            student_id UUID NOT NULL,
                            discount DOUBLE PRECISION,
                            due_date INTEGER NOT NULL,
                            status VARCHAR(50) NOT NULL,
                            CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES aluno(id) ON DELETE CASCADE
);