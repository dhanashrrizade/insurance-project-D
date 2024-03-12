package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Nominee;



public interface NomineeRepository extends JpaRepository<Nominee, Integer>{

}
