package z.repositories.profile.jpa;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import z.repositories.profile.jpa.model.ProfileJpaModel;

public interface ProfileJpaRepository extends JpaRepository<ProfileJpaModel, String>{
    
    @Query(value = "INSERT INTO profile_follow (follower_id, followed_id) VALUES (:followerId, :followedId)", nativeQuery = true)
    public void createFollow(final String followerId, final String followedId);

    public Optional<ProfileJpaModel> findByLogin(final String login);

    public List<ProfileJpaModel> findByLoginContains(final String login);

    @Query(value = "SELECT * FROM profiles INNER JOIN profile_follow ON id=followed_id WHERE follower_id=:id", nativeQuery = true)
    public List<ProfileJpaModel> findFollowsByProfileId(final String id);

}
