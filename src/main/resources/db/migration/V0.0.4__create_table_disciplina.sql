CREATE TABLE disciplina (
                            id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                            name VARCHAR(255) NOT NULL,
                            professor_id UUID,
                            CONSTRAINT fk_professor FOREIGN KEY (professor_id) REFERENCES professor(id) ON DELETE SET NULL
);