package com.codingdojo.relationships.services;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository repo;
	
	public LicenseService(LicenseRepository repo) {
		this.repo = repo;
	}
	
	public License createLicense(License l) {
		l.setNumber(generateLicenseNumber());
		return repo.save(l);
	}
	
	public int generateLicenseNumber() {
		License l = repo.findTopByOrderByNumberDesc();
				if (l == null) {
					return 1;
				}
				else {
					int max = l.getNumber();
					max++;
					return max;
				}
	}
}
