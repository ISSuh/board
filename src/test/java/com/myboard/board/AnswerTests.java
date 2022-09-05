package com.myboard.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myboard.board.answer.Answer;
import com.myboard.board.answer.AnswerRepository;
import com.myboard.board.question.Question;
import com.myboard.board.question.QuestionRepository;

@SpringBootTest
class AnswerTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void createAndSave() {
		Optional<Question> finded = this.questionRepository.findById(2);
		assertTrue(finded.isPresent());

		Question q = finded.get();
		Answer a = new Answer();
		a.setContent("no.");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());	
		this.answerRepository.save(a);
		assertEquals(1, this.answerRepository.count());
	}

	@Test
	void getAnswer() {
		Optional<Answer> finded = this.answerRepository.findById(1);
		assertTrue(finded.isPresent());

		Answer a = finded.get();
		assertEquals(2, a.getQuestion().getId());
	}

	@Transactional
	@Test
	void findByAnswerFromQuestion() {
		Optional<Question> finded = this.questionRepository.findById(2);
		assertTrue(finded.isPresent());

		Question q = finded.get();
		List<Answer> answers = q.getAnswerList();
		assertEquals(1, answers.size());
		assertEquals("no.", answers.get(0).getContent());
	}
}
