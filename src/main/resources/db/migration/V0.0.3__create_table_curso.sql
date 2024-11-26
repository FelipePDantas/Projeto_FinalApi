CREATE TABLE curso (
                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       name VARCHAR(255) NOT NULL,
                       type VARCHAR(50) NOT NULL,
                       monthly_cost NUMERIC(15, 2) NOT NULL
);