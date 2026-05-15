package com.panther.sb_jpql_practice1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);
    List<Employee> findByAge(int age);
    List<Employee> findByCity(String city);
    List<Employee> findByCountry(String country);

    // Correct keyword casing
    List<Employee> findByCityOrCountry(String city, String country);

    // Correct keyword: Containing
    List<Employee> findByNameContaining(String name);

    // JPQL queries fixed
    @Query("SELECT e FROM Employee e WHERE e.city = ?1")
    List<Employee> findEmployeeByCity(String city);

    @Query("SELECT e FROM Employee e WHERE e.city = ?1 AND e.country = ?2")
    List<Employee> getEmployeeByCityAndCountry(String city, String country);
	
    
    @Query(value = "SELECt * FROM Employee e WHERE e.name=?1")
    List<Employee> findByNameNative(String name);
}
