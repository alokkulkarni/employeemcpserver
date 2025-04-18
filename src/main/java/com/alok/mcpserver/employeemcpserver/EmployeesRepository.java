package com.alok.mcpserver.employeemcpserver;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings({"UnusedReturnValue", "SqlDialectInspection"})
@Repository
public interface EmployeesRepository extends CrudRepository<Employees, Integer> {


     @Query("SELECT * FROM employees WHERE department_id = :departmentId")
     List<Employees> findByDepartmentId(int departmentId);

     @Query("SELECT * FROM employees WHERE department_id = :departmentId AND is_active = true")
     List<Employees> findActiveEmployeesByDepartmentId(int departmentId);

     @Query("SELECT * FROM employees WHERE manager_id = :managerId")
     List<Employees> findByManagerId(int managerId);
}
