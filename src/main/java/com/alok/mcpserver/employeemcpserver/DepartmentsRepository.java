package com.alok.mcpserver.employeemcpserver;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends ListCrudRepository<Departments, Integer> {
    // Custom query methods can be defined here if needed
}
