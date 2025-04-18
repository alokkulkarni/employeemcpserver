DROP TABLE
IF EXISTS employees CASCADE;

DROP TABLE
IF EXISTS departments CASCADE;

TRUNCATE TABLE vector_store;

CREATE TABLE IF NOT EXISTS departments (
           id SERIAL PRIMARY KEY,
           name VARCHAR(100) NOT NULL,
           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    hire_date DATE NOT NULL,
    job_title VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    is_Manager BOOLEAN DEFAULT FALSE,
    is_active BOOLEAN DEFAULT TRUE,
    manager_id INT,
    department_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data into departments table
INSERT INTO public.departments (id, name, created_at) VALUES (1, 'Human Resources', '2025-04-07 11:27:30.695235');
INSERT INTO public.departments (id, name, created_at) VALUES (2, 'Finance', '2025-04-07 11:27:30.695235');
INSERT INTO public.departments (id, name, created_at) VALUES (3, 'Engineering', '2025-04-07 11:27:30.695235');
INSERT INTO public.departments (id, name, created_at) VALUES (4, 'Marketing', '2025-04-07 11:27:30.695235');
INSERT INTO public.departments (id, name, created_at) VALUES (5, 'Sales', '2025-04-07 11:27:30.695235');
INSERT INTO public.departments (id, name, created_at) VALUES (6, 'Security', '2025-04-07 12:21:58.890535');
INSERT INTO public.departments (id, name, created_at) VALUES (7, 'IT', '2025-04-07 12:21:58.890535');
INSERT INTO public.departments (id, name, created_at) VALUES (8, 'Loans', '2025-04-07 12:21:58.890535');
INSERT INTO public.departments (id, name, created_at) VALUES (9, 'Digital', '2025-04-07 12:21:58.890535');
INSERT INTO public.departments (id, name, created_at) VALUES (10, 'Support', '2025-04-07 12:21:58.890535');


-- Insert sample data into employees table
INSERT INTO public.employees (id, name, email, phone, hire_date, job_title, salary, is_manager, is_active, manager_id, department_id, created_at) VALUES (1, 'Jane Doe', 'jane.doe@gmail.com', '0123456789', '2012-12-11', 'Engineering Manager', 120000.00, true, true, 0, 3, '2025-04-07 12:25:43.419978');
INSERT INTO public.employees (id, name, email, phone, hire_date, job_title, salary, is_manager, is_active, manager_id, department_id, created_at) VALUES (2, 'John Doe', 'john.doe@gmail.com', '0123456789', '2012-12-11', 'Engineering Lead', 100000.00, false, true, 1, 3, '2025-04-07 12:26:27.666436');
INSERT INTO public.employees (id, name, email, phone, hire_date, job_title, salary, is_manager, is_active, manager_id, department_id, created_at) VALUES (3, 'James Doe', 'james.doe@gmail.com', '0123456789', '2012-12-11', 'Engineering Lead', 80000.00, false, true, 1, 3, '2025-04-07 12:27:00.672535');
INSERT INTO public.employees (id, name, email, phone, hire_date, job_title, salary, is_manager, is_active, manager_id, department_id, created_at) VALUES (4, 'Harry Doe', 'harry.doe@gmail.com', '0123456789', '2012-12-11', 'Engineering Manager', 120000.00, false, true, 0, 1, '2025-04-07 12:27:00.672535');
