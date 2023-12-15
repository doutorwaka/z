package z.controllers.tweet.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateTweetRequestDto(
        @JsonProperty("author_login") String authorLogin,
        String content) {

}
