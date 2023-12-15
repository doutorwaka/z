package z.controllers.tweet.dtos.mappers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import z.controllers.tweet.dtos.ListTweetResponseDto;
import z.controllers.tweet.dtos.TweetDto;
import z.domains.tweet.entities.Tweet;

public class ListTweetResponseDtoMapper implements Function<List<Tweet>, ListTweetResponseDto>{

    public static ListTweetResponseDto mapper(final List<Tweet> tweets) {
        return new ListTweetResponseDtoMapper().apply(tweets);
    }

    @Override
    public ListTweetResponseDto apply(final List<Tweet> input) {
        final var aTweets = input.stream()
            .map((tweet) -> {
                return new TweetDto(
                    tweet.getId(),
                    tweet.getContent(),
                    tweet.getAuthorId(),
                    tweet.getAuthorLogin(),
                    tweet.getLikes(),
                    tweet.getViews(),
                    tweet.getCreatedAt()
                );
            })
            .collect(Collectors.toList());

        return new ListTweetResponseDto(aTweets);
    }
    
}
