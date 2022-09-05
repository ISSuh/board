package com.myboard.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myboard.board.question.Question;
import com.myboard.board.question.QuestionRepository;

@SpringBootTest
class QuestionTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void insert() {
		Question q1 = new Question();
		q1.setSubject("What is this");
		q1.setContent("I want to know about this");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("I know about this");
		q2.setContent("but you don't know this");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}

	@Test
	void findall() {
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("What is this", q.getSubject());
	}

	@Test
	void findById() {
		Optional<Question> finded = this.questionRepository.findById(1);
		if (finded.isPresent()) {
			Question q = finded.get();
			assertEquals("What is this", q.getSubject());
		}
	}

	@Test
	void findBySubject() {
		Question q = this.questionRepository.findBySubject("What is this");
		assertEquals(1, q.getId());
	}

	@Test
	void findBySubjectAndContent() {
		Question q = this.questionRepository.findBySubjectAndContent(
			"What is this",
			"I want to know about this");

		assertEquals(1, q.getId());
	}

	@Test
	void findBySubjectLike() {
		List<Question> list = this.questionRepository.findBySubjectLike("%this");
		Question q = list.get(0);
		assertEquals("What is this", q.getSubject());
	}

	@Test
	void updateQuestion() {
		Optional<Question> finded = this.questionRepository.findById(1);
		assertTrue(finded.isPresent());

		Question q = finded.get();
		q.setSubject("updated this subject");
		this.questionRepository.save(q);
	}

	@Test
	void removeQeustion() {
		Question newQuestion = new Question();
		newQuestion.setSubject("test");
		newQuestion.setContent("test");
		newQuestion.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(newQuestion);

		assertEquals(3, this.questionRepository.count());
		
		Optional<Question> finded = this.questionRepository.findById(newQuestion.getId());
		assertTrue(finded.isPresent());

		Question q = finded.get();
		this.questionRepository.delete(q);
		assertEquals(2, this.questionRepository.count());
	}
}
