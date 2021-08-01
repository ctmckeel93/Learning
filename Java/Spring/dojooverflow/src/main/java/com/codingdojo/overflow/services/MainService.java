package com.codingdojo.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.repositories.AnswerRepository;
import com.codingdojo.overflow.repositories.QuestionRepository;
import com.codingdojo.overflow.repositories.TagRepository;

@Service
public class MainService {

	private final QuestionRepository qRepo;
	private final AnswerRepository aRepo;
	private final TagRepository tRepo;
	
	public MainService(QuestionRepository qRepo, AnswerRepository aRepo, TagRepository tRepo ) {
		this.qRepo = qRepo;
		this.aRepo = aRepo;
		this.tRepo = tRepo;
	}
	
	public List<Question> allQuestions() {
		return qRepo.findAll();
	}
	
	public Question findQuestion(Long id) {
		return qRepo.findById(id).orElse(null);
	}
	
	public Tag findTagWithSubject(String subject) {
		Optional<Tag> t = tRepo.findTagBySubject(subject);
		if (t.isPresent()) {
			return t.get();
		}
		else {
			return null;
		}
	}
		
	public Question createQuestion(Question question) {
		
		return qRepo.save(question);
	}
	
	public Tag createTag(Tag tag) {
		return tRepo.save(tag);
	}
	
	public Answer createAnswer(Answer answer) {
		return aRepo.save(answer);
	}
}
