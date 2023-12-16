package z.services.profile.implementation;

import java.util.List;

import z.domains.profile.entities.Profile;
import z.domains.profile.gateway.ProfileGateway;
import z.services.profile.ProfileService;

public class ProfileServiceImplementation implements ProfileService{

    private ProfileGateway profileGateway;

    private ProfileServiceImplementation(ProfileGateway profileGateway) {
        this.profileGateway = profileGateway;
    }

    public static ProfileServiceImplementation build(ProfileGateway aGateway) {
        return new ProfileServiceImplementation(aGateway);
    }

    @Override
    public Profile get(final String login) {
        final var aProfile = this.profileGateway.findByLogin(login);
        return aProfile;
    }

    @Override
    public Profile follow(String followerLogin, String followedLogin) {
        final var aFollowerProfile = this.profileGateway.findByLogin(followerLogin);
        final var aFollowedProfile = this.profileGateway.findByLogin(followedLogin);

        if(aFollowerProfile == null){
            throw new IllegalArgumentException("Follower not found");
        }

        if(aFollowedProfile == null){
            throw new IllegalArgumentException("Followed not found");
        }

        aFollowerProfile.follow(aFollowedProfile);

        this.profileGateway.update(aFollowerProfile);

        return aFollowerProfile;
    }

    @Override
    public Profile unfollow(String followerLogin, String followedLogin) {
        final var aFollowerProfile = this.profileGateway.findByLogin(followerLogin);
        final var aFollowedProfile = this.profileGateway.findByLogin(followedLogin);

        if(aFollowerProfile == null){
            throw new IllegalArgumentException("Follower not found");
        }

        if(aFollowedProfile == null){
            throw new IllegalArgumentException("Followed not found");
        }

        aFollowerProfile.unfollow(aFollowedProfile);

        this.profileGateway.update(aFollowerProfile);

        return aFollowerProfile;
    }

    @Override
    public Profile create(final String aName, final String aLogin, final String anEmail) {
        final var existentProfile = this.profileGateway.findByLogin(aLogin);

        if (existentProfile != null) {
            return existentProfile;
        }

        final var aProfile = Profile.build(aName, anEmail, aLogin);

        this.profileGateway.create(aProfile);

        return aProfile;
    }

    @Override
    public List<Profile> search(final String aLogin) {
        final var aProfiles = this.profileGateway.searchByLogin(aLogin);
        return aProfiles;
    }

    @Override
    public boolean isFollowing(final String followerLogin, final String followedLogin) {
        final var aFollowerProfile = this.profileGateway.findByLogin(followerLogin);
        final var aFollowedProfile = this.profileGateway.findByLogin(followedLogin);

        if(aFollowerProfile == null){
            throw new IllegalArgumentException("Follower not found");
        }

        if(aFollowedProfile == null){
            throw new IllegalArgumentException("Followed not found");
        }

        return aFollowerProfile.getFollowed().containsKey(aFollowedProfile.getId());
    }
    
}
