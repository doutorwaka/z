package z.domains.tweet.gateway;

import java.util.List;

import z.domains.tweet.entities.Tweet;

public interface TweetGateway {
    
    public void create(final Tweet aTweet);
    public void update(final Tweet aTweet);
    public Tweet findById(final String id);
    public List<Tweet> findByAuthorId(final String authorId);

}
