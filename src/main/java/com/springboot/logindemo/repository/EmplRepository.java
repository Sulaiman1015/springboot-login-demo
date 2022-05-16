package com.springboot.logindemo.repository;

import com.springboot.logindemo.entity.Empl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmplRepository extends JpaRepository<Empl,Integer> {
}


