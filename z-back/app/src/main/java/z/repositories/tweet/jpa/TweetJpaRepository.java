package z.repositories.tweet.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import z.repositories.tweet.jpa.model.TweetJpaModel;

public interface TweetJpaRepository extends JpaRepository<TweetJpaModel, String> {

}
