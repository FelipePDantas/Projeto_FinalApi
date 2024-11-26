CREATE TABLE aluno (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    course_id UUID,
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES curso(id) ON DELETE SET NULL
);