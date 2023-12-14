package z.repositories.profile.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import z.repositories.profile.jpa.model.ProfileJpaModel;

public interface ProfileJpaRepository extends JpaRepository<ProfileJpaModel, String>{
    
}
