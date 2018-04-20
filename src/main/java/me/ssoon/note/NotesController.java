package me.ssoon.note;

import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NotesController {

  private NotesRepository notesRepository;

  @GetMapping(value = "/notes")
  public List<Notes> getAllNotes() {
    return notesRepository.findAll();
  }

  @PostMapping(value = "/notes")
  public Notes createNote(final @Valid @RequestBody NotesSaveRequestDto notesSaveRequestDto) {
    return notesRepository.save(notesSaveRequestDto.toEntity());
  }

  @GetMapping(value = "/notes/{id}")
  public Notes getNoteById(final @PathVariable(value = "id") Long noteId) {
    return notesRepository.findById(noteId)
        .orElseThrow(() -> new NotesNotFoundException("id", noteId));
  }

  @PutMapping(value = "/notes/{id}")
  public Notes updateNote(final @PathVariable(value = "id") Long noteId,
      final @Valid @RequestBody NotesSaveRequestDto notesSaveRequestDto) {
    final Notes note = notesRepository.findById(noteId)
        .orElseThrow(() -> new NotesNotFoundException("notes", noteId));
    note.updateNote(notesSaveRequestDto);
    return notesRepository.save(note);
  }

  @DeleteMapping(value = "/notes/{id}")
  public ResponseEntity<Notes> deleteNote(final @PathVariable(value = "id") Long noteId) {
    final Notes note = notesRepository.findById(noteId)
        .orElseThrow(() -> new NotesNotFoundException("id", noteId));
    notesRepository.delete(note);
    return ResponseEntity.ok().build();
  }
}
