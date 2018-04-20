package me.ssoon.note;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotesRepositoryTest {

  @Autowired
  NotesRepository notesRepository;

  @Test
  public void 노트저장_불러오기() {
    notesRepository.save(Notes.builder()
        .title("테스트")
        .content("테스트 컨텐츠")
        .build());

    final List<Notes> notesList = notesRepository.findAll();

    final Notes notes = notesList.get(0);
    assertThat(notes.getTitle(), is("테스트"));
    assertThat(notes.getContent(), is("테스트 컨텐츠"));
  }
}