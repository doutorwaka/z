package z.repositories.tweet.jpa;

import java.util.List;

import z.domains.tweet.entities.Tweet;
import z.domains.tweet.gateway.TweetGateway;
import z.repositories.profile.jpa.ProfileJpaRepository;
import z.repositories.tweet.jpa.mapper.TweetJpaModelToTweetMapper;
import z.repositories.tweet.jpa.model.TweetJpaModel;

public class TweetJpaGateway implements TweetGateway {

    private TweetJpaRepository tweetRepository;
    private ProfileJpaRepository profileRepository;

    private TweetJpaGateway(final TweetJpaRepository tweetRepository,
            final ProfileJpaRepository profileRepository) {
        this.tweetRepository = tweetRepository;
        this.profileRepository = profileRepository;
    }

    public static TweetJpaGateway build(final TweetJpaRepository tweetRepository,
            final ProfileJpaRepository profileRepository) {
        return new TweetJpaGateway(tweetRepository, profileRepository);
    }

    @Override
    public void create(final Tweet aTweet) {
        final var author = this.profileRepository.findById(aTweet.getAuthorId()).orElse(null);

        if (author == null) {
            throw new RuntimeException("Author not found");
        }

        final var aTweetModel = new TweetJpaModel(
                aTweet.getId(),
                aTweet.getContent(),
                author,
                aTweet.getLikes(),
                aTweet.getViews(),
                aTweet.getCreatedAt());

        this.tweetRepository.save(aTweetModel);
    }

    @Override
    public void update(final Tweet aTweet) {
        final var author = this.profileRepository.findById(aTweet.getAuthorId()).orElse(null);

        if (author == null) {
            throw new RuntimeException("Author not found");
        }

        final var aTweetModel = new TweetJpaModel(
                aTweet.getId(),
                aTweet.getContent(),
                author,
                aTweet.getLikes(),
                aTweet.getViews(),
                aTweet.getCreatedAt());

        this.tweetRepository.save(aTweetModel);
    }

    @Override
    public Tweet findById(final String id) {
        final var aTweetModel = this.tweetRepository.findById(id).orElse(null);

        if (aTweetModel == null) {
            return null;
        }

        final var aTweet = TweetJpaModelToTweetMapper.mapper(aTweetModel);

        return aTweet;
    }

    @Override
    public List<Tweet> findByAuthorId(final String authorId) {
        final var aTweetsModel = this.tweetRepository.findByAuthorId(authorId);

        final var aTweets = aTweetsModel.stream()
                .map(TweetJpaModelToTweetMapper::mapper)
                .toList();

        return aTweets;
    }

}
