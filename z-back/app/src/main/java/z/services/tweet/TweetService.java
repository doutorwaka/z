package z.services.tweet;

import java.util.List;

import z.domains.tweet.entities.Tweet;

public interface TweetService {
    
    public Tweet create(final String authorId, final String content);
    public Tweet like(final String id);
    public Tweet unlike(final String id);
    public Tweet view(final String id);
    public List<Tweet> findByAuthor(final String authorId);
    public List<Tweet> findByFollowed(final String profileLogin);

}
