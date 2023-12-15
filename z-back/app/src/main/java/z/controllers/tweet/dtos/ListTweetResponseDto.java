package z.controllers.tweet.dtos;

import java.util.List;

public record ListTweetResponseDto(
        List<TweetDto> tweets) {

}
