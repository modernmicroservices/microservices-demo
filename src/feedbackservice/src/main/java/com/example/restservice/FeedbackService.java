package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 	
public class FeedbackService{
	
	@Autowired
	FeedbackRepository feedbackRepo;
	
	public List<Feedback> getAllFeedbacks() {
		return (List<Feedback>) feedbackRepo.findAll();
	}

	public Feedback getFeedback(long id) {
		return feedbackRepo.findById(id);
	}

	public void delete(long id) {
		feedbackRepo.deleteById(id);	
	}

	public void submitNewFeedback(Feedback feedback) {
		feedbackRepo.save(feedback);		
	}

	public Feedback updateFeedback(Feedback feedback) {
		feedbackRepo.save(feedback);
		return feedback;
	}

}
