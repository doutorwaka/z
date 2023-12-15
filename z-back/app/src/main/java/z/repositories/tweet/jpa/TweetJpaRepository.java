package z.repositories.tweet.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.OrderBy;
import z.repositories.tweet.jpa.model.TweetJpaModel;

public interface TweetJpaRepository extends JpaRepository<TweetJpaModel, String> {

    @OrderBy("created_at DESC")
    @Query(value = "SELECT * FROM tweets WHERE author_id = :authorId", nativeQuery = true)
    public List<TweetJpaModel> findByAuthorId(final String authorId);

}
