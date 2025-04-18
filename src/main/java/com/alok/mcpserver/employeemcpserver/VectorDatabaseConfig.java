package com.alok.mcpserver.employeemcpserver;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SuppressWarnings("ConstantValue")
@Configuration
public class VectorDatabaseConfig {

    /**
     * This method populates the vector database with the data from the departments and employees tables.
     * It creates a document for each department and employee and adds it to the vector store.
     */
    @Bean
    CommandLineRunner runner(
            DepartmentsRepository departmentsRepository,
            EmployeesRepository employeesRepository,
            VectorStore vectorStore
    ) {
        return args -> {
            // Populate the vector database with the data from the departments and employees tables
            departmentsRepository.findAll().forEach(department -> {
                var departmentDocument = new Document("id: %d, name: %s, created_at: %s"
                        .formatted(department.id(), department.name(), department.created_at()));
                vectorStore.add(List.of(departmentDocument));
            });

            employeesRepository.findAll().forEach(employee -> {
                if (employee.is_manager()) {
                    var managerDocument = new Document("id: %d, name: %s, email: %s, phone: %s, hire_date: %s, job_title: %s, manager_id: %d, department_id: %d, is_active: %b, is_manager: %b, salary: %.2f, created_at: %s"
                            .formatted(employee.id(), employee.name(), employee.email(), employee.phone(), employee.hire_date(), employee.job_title(), employee.manager_id(), employee.department_id(), employee.is_active(), employee.is_manager(), employee.salary(), employee.created_at()));
                    vectorStore.add(List.of(managerDocument));
                } else {
                    var employeeDocument = new Document("id: %d, name: %s, email: %s, phone: %s, hire_date: %s, job_title: %s, manager_id: %d, department_id: %d, is_active: %b, is_manager: %b, created_at: %s"
                            .formatted(employee.id(), employee.name(), employee.email(), employee.phone(), employee.hire_date(), employee.job_title(), employee.manager_id(), employee.department_id(), employee.is_active(), employee.is_manager(), employee.created_at()));
                    vectorStore.add(List.of(employeeDocument));
                }
            });
        };
    }
}
