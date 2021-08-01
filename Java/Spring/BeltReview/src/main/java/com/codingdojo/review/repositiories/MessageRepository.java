package com.codingdojo.review.repositiories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.review.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
