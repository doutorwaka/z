package z.controllers.tweet.dtos.mappers;

import java.util.function.Function;

import z.controllers.tweet.dtos.LikeTweetResponseDto;
import z.domains.tweet.entities.Tweet;

public class TweetToLikeTweetResponseDtoMapper implements Function<Tweet, LikeTweetResponseDto> {

    public static LikeTweetResponseDto mapper(final Tweet aTweet) {
        return new TweetToLikeTweetResponseDtoMapper().apply(aTweet);
    }

    @Override
    public LikeTweetResponseDto apply(Tweet input) {
        return new LikeTweetResponseDto(
                input.getId(),
                input.getContent(),
                input.getAuthorId(),
                input.getAuthorLogin(),
                input.getLikes(),
                input.getViews(),
                input.getCreatedAt());
    }

}
