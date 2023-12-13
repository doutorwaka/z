package z.services.profile;

import java.util.List;

import z.domains.profile.entities.Profile;

public interface ProfileService {
    
    public Profile get(final String login);
    public Profile follow(final String followerLogin, final String followedLogin);
    public Profile create(final String aName, final String aLogin, final String anEmail);
    public List<Profile> search(final String aLogin);
    public boolean isFollowing(final String followerLogin, final String followedLogin);

}
