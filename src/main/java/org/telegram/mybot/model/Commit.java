package org.telegram.mybot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Commit {

    @JsonProperty("id")
    String id;

    @JsonProperty("message")
    String message;

    @JsonProperty("author")
    Author author;

    @JsonProperty("added")
    List<String> added;

    @JsonProperty("removed")
    List<String> removed;

    @JsonProperty("modified")
    List<String> modified;

}
