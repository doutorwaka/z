package z.repositories.profile.jpa;

import java.util.List;

import z.domains.profile.entities.Profile;
import z.domains.profile.gateway.ProfileGateway;
import z.repositories.profile.jpa.mapper.ProfileJpaModelToProfileMapper;
import z.repositories.profile.jpa.mapper.ProfileToProfileJpaModelMapper;

public class ProfileJpaGateway implements ProfileGateway {

    private ProfileJpaRepository profileRepository;

    private ProfileJpaGateway(final ProfileJpaRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public static ProfileJpaGateway build(final ProfileJpaRepository profileRepository) {
        return new ProfileJpaGateway(profileRepository);
    }

    @Override
    public void create(final Profile profile) {
        final var profileJpaModel = ProfileToProfileJpaModelMapper.mapper(profile);

        this.profileRepository.save(profileJpaModel);

        profile.getFollowed()
                .values()
                .forEach((followed) -> {
                    this.profileRepository.createFollow(profile.getId(), followed.getId());
                });
    }

    @Override
    public void update(final Profile profile) {
        final var profileJpaModel = ProfileToProfileJpaModelMapper.mapper(profile);
        this.profileRepository.save(profileJpaModel);
    }

    @Override
    public Profile findById(final String id) {
        final var aProfileModel = this.profileRepository.findById(id).orElse(null);

        if (aProfileModel == null) {
            return null;
        }

        return ProfileJpaModelToProfileMapper.mapper(aProfileModel);
    }

    @Override
    public Profile findByLogin(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLogin'");
    }

    @Override
    public List<Profile> searchByLogin(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByLogin'");
    }

    @Override
    public List<Profile> findFollowedByProfileId(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFollowedByProfileId'");
    }

}
