package com.myboard.board.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.myboard.board.question.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
  public final AnswerRepository answerRepository;

  public void create(Question question, String content) {
    Answer answer = new Answer();
    answer.setContent(content);
    answer.setCreateDate(LocalDateTime.now());
    answer.setQuestion(question);
    this.answerRepository.save(answer);
  }
}
