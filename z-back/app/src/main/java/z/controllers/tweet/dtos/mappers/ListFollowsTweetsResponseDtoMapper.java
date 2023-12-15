package z.controllers.tweet.dtos.mappers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import z.controllers.tweet.dtos.ListFollowsTweetsResponseDto;
import z.controllers.tweet.dtos.TweetDto;
import z.domains.tweet.entities.Tweet;

public class ListFollowsTweetsResponseDtoMapper implements Function<List<Tweet>, ListFollowsTweetsResponseDto> {

    public static ListFollowsTweetsResponseDto mapper(final List<Tweet> tweets) {
        return new ListFollowsTweetsResponseDtoMapper().apply(tweets);
    }

    @Override
    public ListFollowsTweetsResponseDto apply(List<Tweet> input) {
        final var aTweets = input.stream()
                .map((tweet) -> {
                    return new TweetDto(
                            tweet.getId(),
                            tweet.getContent(),
                            tweet.getAuthorId(),
                            tweet.getAuthorLogin(),
                            tweet.getLikes(),
                            tweet.getViews(),
                            tweet.getCreatedAt());
                })
                .collect(Collectors.toList());

        return new ListFollowsTweetsResponseDto(aTweets);
    }

}
