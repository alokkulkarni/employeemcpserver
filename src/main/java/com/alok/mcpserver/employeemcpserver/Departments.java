package com.alok.mcpserver.employeemcpserver;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("departments")
public record Departments(
        @Id
        int id,
        String name,
        LocalDate created_at
) { }
