package z.controllers.tweet.dtos.mappers;

import java.util.function.Function;

import z.controllers.tweet.dtos.ViewTweetResponseDto;
import z.domains.tweet.entities.Tweet;

public class TweetToViewTweetResponseDto implements Function<Tweet, ViewTweetResponseDto> {

    public static ViewTweetResponseDto mapper(final Tweet aTweet) {
        return new TweetToViewTweetResponseDto().apply(aTweet);
    }

    @Override
    public ViewTweetResponseDto apply(final Tweet input) {
        return new ViewTweetResponseDto(
                input.getId(),
                input.getContent(),
                input.getAuthorId(),
                input.getAuthorLogin(),
                input.getLikes(),
                input.getViews(),
                input.getCreatedAt());
    }

}
