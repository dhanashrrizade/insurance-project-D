package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Nominee;
import com.example.demo.repository.NomineeRepository;
import com.example.demo.service.NomineeService;

public class NomineeServiceImpl implements NomineeService {
    @Autowired
	private NomineeRepository nomineeRepository;
	@Override
	public Nominee saveNominee(Nominee nominee) {
		Nominee nominee1=nomineeRepository.save(nominee);
		return nominee1;
	}

}
