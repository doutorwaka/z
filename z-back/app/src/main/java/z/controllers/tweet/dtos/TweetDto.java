package z.controllers.tweet.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TweetDto(
        String id,
        String content,
        @JsonProperty("author_id") String authorId,
        @JsonProperty("author_login") String authorLogin,
        int likes,
        int views,
        @JsonProperty("created_at") Instant createdAt) {

}
