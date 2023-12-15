package z.services.tweet.implementation;

import java.util.List;

import z.domains.profile.gateway.ProfileGateway;
import z.domains.tweet.entities.Tweet;
import z.domains.tweet.gateway.TweetGateway;
import z.services.tweet.TweetService;

public class TweetServiceImplementation implements TweetService {

    private TweetGateway tweetGateway;
    private ProfileGateway profileGateway;

    private TweetServiceImplementation(final TweetGateway tweetGateway,
            final ProfileGateway profileGateway) {
        this.tweetGateway = tweetGateway;
        this.profileGateway = profileGateway;
    }

    public static TweetServiceImplementation build(final TweetGateway tweetGateway,
            final ProfileGateway profileGateway) {
        return new TweetServiceImplementation(tweetGateway, profileGateway);
    }

    @Override
    public Tweet create(final String authorLogin, final String content) {
        final var author = this.profileGateway.findByLogin(authorLogin);

        if (author == null) {
            throw new IllegalArgumentException("Author not found");
        }

        final var tweet = Tweet.build(content, author.getId(), author.getLogin());

        this.tweetGateway.create(tweet);

        return tweet;
    }

    @Override
    public Tweet like(final String id) {
        final var aTweet = this.tweetGateway.findById(id);

        if (aTweet == null) {
            throw new IllegalArgumentException("Tweet not found");
        }

        aTweet.like();

        this.tweetGateway.update(aTweet);

        return aTweet;
    }

    @Override
    public Tweet unlike(final String id) {
        final var aTweet = this.tweetGateway.findById(id);

        if (aTweet == null) {
            throw new IllegalArgumentException("Tweet not found");
        }

        aTweet.unlike();

        this.tweetGateway.update(aTweet);

        return aTweet;
    }

    @Override
    public Tweet view(final String id) {
        final var aTweet = this.tweetGateway.findById(id);

        if (aTweet == null) {
            throw new IllegalArgumentException("Tweet not found");
        }

        aTweet.view();

        this.tweetGateway.update(aTweet);

        return aTweet;
    }

    @Override
    public List<Tweet> findByAuthor(final String authorLogin) {
        final var author = this.profileGateway.findByLogin(authorLogin);

        if (author == null) {
            throw new IllegalArgumentException("Author not found");
        }

        final var tweets = this.tweetGateway.findByAuthorId(author.getId());

        return tweets;
    }

    @Override
    public List<Tweet> findByFollowed(final String profileLogin) {
        final var profile = this.profileGateway.findByLogin(profileLogin);

        if (profile == null) {
            throw new IllegalArgumentException("Profile not found");
        }

        final var followed = this.profileGateway.findFollowedByProfileId(profile.getId());

        final var unorderedTweets = followed.stream()
                .map(followedProfile -> this.tweetGateway.findByAuthorId(followedProfile.getId()))
                .flatMap(List::stream)
                .toList();

        final var orderedTweets = unorderedTweets.stream()
                .sorted((tweet1, tweet2) -> tweet1.getCreatedAt().compareTo(tweet2.getCreatedAt()))
                .toList();

        return orderedTweets;
    }

}
