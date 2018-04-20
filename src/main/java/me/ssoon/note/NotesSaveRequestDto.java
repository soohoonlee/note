package me.ssoon.note;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotesSaveRequestDto {

  private String title;
  private String content;

  public Notes toEntity() {
    return Notes.builder()
        .title(title)
        .content(content)
        .build();
  }
}
