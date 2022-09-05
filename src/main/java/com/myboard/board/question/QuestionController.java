package com.myboard.board.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {

  private final QuestionRepository questionRepository;

  @RequestMapping("/question/list")
  public String list(Model model) {
    List<Question> questions = this.questionRepository.findAll();
    model.addAttribute("questions", questions);
    return "question_list";
  }
}
