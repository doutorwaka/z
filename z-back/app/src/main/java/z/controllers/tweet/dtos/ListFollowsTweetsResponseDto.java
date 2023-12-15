package z.controllers.tweet.dtos;

import java.util.List;

public record ListFollowsTweetsResponseDto(
        List<TweetDto> tweets) {

}
