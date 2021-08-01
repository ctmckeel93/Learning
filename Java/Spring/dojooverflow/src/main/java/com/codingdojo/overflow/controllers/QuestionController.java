package com.codingdojo.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.services.MainService;

@Controller
public class QuestionController {

	private final MainService service;
	
	public QuestionController(MainService service) {
		this.service = service;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Question> questions = service.allQuestions();
		model.addAttribute("questions", questions);
		return "dashboard.jsp";
	}
	
	@RequestMapping(value="/questions", method=RequestMethod.POST)
	public String submitQuestion(@Valid @ModelAttribute("question") Question q, BindingResult result, @RequestParam("tags") String tags) {
		ArrayList<Tag> dividedTags = splitTags(tags);
		System.out.println(dividedTags);
		
		for (Tag tag : dividedTags) {
			if (q.getTags() != null) {
				
				q.getTags().add(tag);
			}
			else {
				q.setTags((List<Tag>)dividedTags);
				service.createQuestion(q);
				return "redirect:/dashboard";
			}
		}
		service.createQuestion(q);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id,@ModelAttribute("answer") Answer answer, Model model) {
		Question q = service.findQuestion(id);
		if (q != null) {
			model.addAttribute("question", q);
		}
		return "answers.jsp";
	}
	
	@RequestMapping(value="/addAnswer", method=RequestMethod.POST)
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("question", answer.getQuestion());
			return "answers.jsp";
		}
		else {
			Answer newAnswer = service.createAnswer(answer);
			return "redirect:/questions/" + newAnswer.getQuestion().getId();
		}
	}
	public ArrayList<Tag> splitTags(String string) {
		String[] splitStrings = new String[3];
		
		for (int i = 0; i < string.length(); i++) {
			String result = string.trim();
			splitStrings = result.split(",");
		}
		
		ArrayList<Tag> tags = new ArrayList<Tag>();
		for (int i = 0; i < splitStrings.length; i++) {
			Tag newTag = new Tag();
			service.createTag(newTag);
			newTag.setSubject(splitStrings[i]);
			tags.add(newTag);
		}
		return tags;
	}
}
