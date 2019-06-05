/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.Employee;
import etracer.com.projectetracer.entities.Province;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Relion31
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query(
            value = "SELECT e.employeeId, e.employeeName, e.address, e.dateOfBirth, e.dateOfJoin, e.managerId, e.salary, e.gender, e.phone, e.email, e.password, e.departmentId, d.departmentName, e.jobId, j.jobName, e.isDelete\n"
            + "FROM employee e\n"
            + "JOIN department d ON e.departmentId=d.departmentId\n"
            + "JOIN job j ON e.jobId=j.jobId\n"
            + "WHERE e.isDelete =\'false\'",
            nativeQuery = true)
    List<Employee> getAll();
}
