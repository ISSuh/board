package com.myboard.board.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.myboard.board.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
  public final QuestionRepository questionRepository;

  public List<Question> getList() {
    return questionRepository.findAll();
  }

  public Question getQeustion(Integer id) {
    Optional<Question> finded = this.questionRepository.findById(id);
    if (finded.isPresent()) {
      return finded.get();
    } else {
      throw new DataNotFoundException("question not found");
    }
  }
}
