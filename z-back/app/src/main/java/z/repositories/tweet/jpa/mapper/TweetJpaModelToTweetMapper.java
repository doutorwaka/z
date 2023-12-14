package z.repositories.tweet.jpa.mapper;

import java.util.function.Function;

import z.domains.tweet.entities.Tweet;
import z.repositories.tweet.jpa.model.TweetJpaModel;

public class TweetJpaModelToTweetMapper implements Function<TweetJpaModel, Tweet> {

    public static Tweet mapper(final TweetJpaModel aTweetModel) {
        return new TweetJpaModelToTweetMapper().apply(aTweetModel);
    }

    @Override
    public Tweet apply(final TweetJpaModel input) {
        final var aTweet = Tweet.with(
                input.getId(),
                input.getContent(),
                input.getAuthor().getId(),
                input.getAuthor().getLogin(),
                input.getLikes(),
                input.getViews(),
                input.getCreatedAt());

        return aTweet;
    }

}
