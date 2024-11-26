CREATE TABLE fatura (
                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                        student_financial_id UUID NOT NULL,
                        due_date TIMESTAMP NOT NULL,
                        paid_on TIMESTAMP,
                        created_at TIMESTAMP NOT NULL,
                        CONSTRAINT fk_student_financial FOREIGN KEY (student_financial_id) REFERENCES financeiro_aluno(id) ON DELETE CASCADE
);