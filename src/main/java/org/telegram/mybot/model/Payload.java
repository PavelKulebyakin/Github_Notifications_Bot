package org.telegram.mybot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payload {

    @JsonProperty("repository")
    Repository repository;

    @JsonProperty("sender")
    Sender sender;

    @JsonProperty("commits")
    List<Commit> commits;

}
