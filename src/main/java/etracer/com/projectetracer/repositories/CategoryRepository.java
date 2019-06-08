/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.Assessment;
import etracer.com.projectetracer.entities.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author yosef
 */
public interface CategoryRepository extends CrudRepository<Category, String>{

    @Query(
            value = "SELECT c.categoryId, c.assessmentId, c.evaluationId, c.employeeId, c.isDelete \n"
            + "FROM category c\n"
            + "JOIN assessment a ON c.assessmentId=a.assessmentId\n"
            + "JOIN evaluationId e ON c.evaluationId=e.evaluationId\n"        
            + "JOIN employee e ON c.employeeId=e.employeeId\n"
            + "WHERE c.isDelete='false'",
            nativeQuery = true)
    List<Category> getAll();
}
