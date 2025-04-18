package com.alok.mcpserver.employeemcpserver;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("employees")
public record Employees(
        @Id
        int id,
        String name,
        String email,
        String phone,
        LocalDate hire_date,
        String job_title,
        int manager_id,
        int department_id,
        Boolean is_active,
        Boolean is_manager,
        Double salary,
        String created_at

) { }
