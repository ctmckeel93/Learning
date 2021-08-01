package com.codingdojo.overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	public List<Tag> findAll();
	Optional<Tag> findTagBySubject(String s);
}
