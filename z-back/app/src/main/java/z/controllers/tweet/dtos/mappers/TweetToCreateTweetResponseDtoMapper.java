package z.controllers.tweet.dtos.mappers;

import java.util.function.Function;

import z.controllers.tweet.dtos.CreateTweetResponseDto;
import z.domains.tweet.entities.Tweet;

public class TweetToCreateTweetResponseDtoMapper implements Function<Tweet, CreateTweetResponseDto> {

    public static CreateTweetResponseDto mapper(final Tweet aTweet) {
        return new TweetToCreateTweetResponseDtoMapper().apply(aTweet);
    }

    @Override
    public CreateTweetResponseDto apply(final Tweet input) {
        return new CreateTweetResponseDto(
                input.getId(),
                input.getContent(),
                input.getAuthorId(),
                input.getAuthorLogin(),
                input.getLikes(),
                input.getViews(),
                input.getCreatedAt());
    }

}
