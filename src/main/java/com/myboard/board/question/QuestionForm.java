package com.myboard.board.question;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
  @NotEmpty(message="need title")
  @Size(max=200)
  private String subject;

  @NotEmpty(message="need content")
  private String content;
}
