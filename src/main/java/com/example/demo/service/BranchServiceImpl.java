package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService
{
	@Autowired
     private BranchRepository branchRepository;
	
	@Override
	public void deleteBranch(Integer id) {
		branchRepository.deleteById(id); 
	
		
	}

}
