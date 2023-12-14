package z.repositories.profile.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import z.repositories.profile.jpa.model.ProfileJpaModel;

public interface ProfileJpaRepository extends JpaRepository<ProfileJpaModel, String>{
    
    @Query(value = "INSERT INTO profile_follow (follower_id, followed_id) VALUES (:followerId, :followedId)", nativeQuery = true)
    public void createFollow(final String followerId, final String followedId);

}
