package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;

	@GetMapping("/feedback")
	public List<Feedback> getAllFeedbacks() {
		return feedbackService.getAllFeedbacks();
	}

	@GetMapping("/feedback/{id}")
	public Feedback getFeedback(@PathVariable("id") long id) {
		return feedbackService.getFeedback(id);
	}

	@PostMapping("/feedback")
	public Long updateFeedback(@RequestBody Feedback feedback) {
		feedbackService.submitNewFeedback(feedback);  
		return feedback.getId();
	}
	
	@PutMapping("/feedback")
	public Feedback submitFeedback(@RequestBody Feedback feedback) {
		return feedbackService.updateFeedback(feedback);  
	}

	@DeleteMapping("/feedback/{id}")
	private void deleteFeedback(@PathVariable("id") long id) {
		feedbackService.delete(id);
	}
}
