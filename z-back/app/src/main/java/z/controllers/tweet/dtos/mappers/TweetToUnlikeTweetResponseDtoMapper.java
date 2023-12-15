package z.controllers.tweet.dtos.mappers;

import java.util.function.Function;

import z.controllers.tweet.dtos.UnlikeTweetResponseDto;
import z.domains.tweet.entities.Tweet;

public class TweetToUnlikeTweetResponseDtoMapper implements Function<Tweet, UnlikeTweetResponseDto> {

    public static UnlikeTweetResponseDto mapper(final Tweet aTweet) {
        return new TweetToUnlikeTweetResponseDtoMapper().apply(aTweet);
    }

    @Override
    public UnlikeTweetResponseDto apply(final Tweet input) {
        return new UnlikeTweetResponseDto(
                input.getId(),
                input.getContent(),
                input.getAuthorId(),
                input.getAuthorLogin(),
                input.getLikes(),
                input.getViews(),
                input.getCreatedAt());
    }

}
