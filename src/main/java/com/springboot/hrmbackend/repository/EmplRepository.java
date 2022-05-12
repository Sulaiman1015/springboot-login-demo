package com.springboot.hrmbackend.repository;

import com.springboot.hrmbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmplRepository extends JpaRepository<Employee,Long> {

}


