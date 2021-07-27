package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository repo) {
		this.langRepo = repo;
	}
	
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	public Language createLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language>  opt = langRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		else {
			return null;
		}
	}
	
	public Language updateLanguage(Language lang) {
		Optional<Language> opt = langRepo.findById(lang.getId());
		if (opt.isPresent()) {
			Language languageToUpdate = opt.get();
			languageToUpdate.setName(lang.getName());
			languageToUpdate.setCreator(lang.getCreator());
			languageToUpdate.setVersionNumber(lang.getVersionNumber());
			return langRepo.save(languageToUpdate);
		}
		else {
			return null;
		}
	}
	
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
}
