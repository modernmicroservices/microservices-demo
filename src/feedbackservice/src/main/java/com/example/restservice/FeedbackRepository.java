package com.example.restservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
	Feedback findById(long id);
}
