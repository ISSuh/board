package com.myboard.board.question;

import java.io.Console;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

  private final QuestionService questionService;

  @RequestMapping("/list")
  public String list(Model model) {
    List<Question> questions = this.questionService.getList();
    model.addAttribute("questions", questions);

    System.out.println("count : " + questions.size());
    for (Question question : questions) {
      System.out.println("subject : " + question.getSubject()
      );
    }

    return "question_list";
  }

  @RequestMapping("/detail/{id}")
  public String detail(Model model, @PathVariable("id") Integer id) {
    Question question = this.questionService.getQeustion(id);
    model.addAttribute("question",  question);
    return "question_detail";
  }
}
