package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BranchService;

@RestController
public class BranchController 
{
 @Autowired
  private BranchService branchService;
 
 @DeleteMapping("/deleteBranch/{id}")
	public void deleteBranch(@PathVariable("id") Integer id) { // id contain 1
		
		branchService.deleteBranch(id);
	}
}
