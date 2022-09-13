package com.myboard.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myboard.board.question.QuestionService;

@SpringBootTest
public class ContentCreateTest {
  @Autowired
  private QuestionService questionService;

  @Test
  void testContentCreate() {
    for (int i = 0 ; i <= 300 ; ++i) {
      String subject = String.format("Test Content[%03d]", i);
      String content = "empty";
      this.questionService.create(subject, content);
    }
  }
}
