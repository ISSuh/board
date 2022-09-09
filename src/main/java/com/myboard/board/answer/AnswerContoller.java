package com.myboard.board.answer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myboard.board.question.Question;
import com.myboard.board.question.QuestionService;

import groovyjarjarpicocli.CommandLine.Model;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerContoller {
  private final QuestionService questionService;
  private final AnswerService answerService;

  @PostMapping("/create/{id}")
  public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
      Question question = this.questionService.getQeustion(id);
      this.answerService.create(question, content);
      return String.format("redirect:/question/detail/%d", id);
  }
}