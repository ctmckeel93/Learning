package com.codingdojo.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.models.Tag;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {
	public List<Question> findAll();
	
}
