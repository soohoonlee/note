package me.ssoon.note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.ssoon.common.BaseTimeEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Notes extends BaseTimeEntity {

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank
  @Column(length = 500, nullable = false)
  private String title;

  @NotBlank
  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  @Builder
  public Notes(final Long id, final String title, final String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }

  public void updateNote(NotesSaveRequestDto notes) {
    this.title = notes.getTitle();
    this.content = notes.getContent();
  }
}
