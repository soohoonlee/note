package me.ssoon.note;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotesNotFoundException extends RuntimeException {

  private final String fieldName;
  private final Object fieldValue;

  public NotesNotFoundException(final String fieldName, final Object fieldValue) {
    super(String.format("Note not found with %s : '%s'", fieldName, fieldValue));
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }

  public String getFieldName() {
    return fieldName;
  }

  public Object getFieldValue() {
    return fieldValue;
  }
}
