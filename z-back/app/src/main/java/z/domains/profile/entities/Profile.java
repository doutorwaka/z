package z.domains.profile.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Profile {

    private String id;
    private String name;
    private String email;
    private String login;
    private Map<String, Profile> followed;

    private Profile(final String id, final String name, final String email, final String login,
            final Map<String, Profile> followed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.followed = followed;
        this.validate();
    }

    public static Profile build(final String aName, final String anEmail, final String aLogin) {
        return new Profile(
                UUID.randomUUID().toString(),
                aName,
                anEmail,
                aLogin,
                new HashMap<String, Profile>());
    }

    public static Profile with(final String anId, final String aName, final String anEmail,
            final String aLogin, final Map<String, Profile> aFollowed) {
        return new Profile(
                anId,
                aName,
                anEmail,
                aLogin,
                aFollowed);
    }

    private void validate() {
        if (this.id == null) {
            throw new IllegalArgumentException("Profile id should not be null");
        }

        if (this.id.isBlank()) {
            throw new IllegalArgumentException("Profile id should not be blank");
        }

        if (this.id.length() != 36) {
            throw new IllegalArgumentException("Profile id should be a valid uuid");
        }

        if (this.name == null) {
            throw new IllegalArgumentException("Profile name should not be null");
        }

        if (this.name.length() < 3) {
            throw new IllegalArgumentException("Profile name should be at least 3 characters");
        }

        if (this.email == null) {
            throw new IllegalArgumentException("Profile email should not be null");
        }

        if (!this.email.contains("@")) {
            throw new IllegalArgumentException("Profile email should be a valid email");
        }

        if (this.login == null) {
            throw new IllegalArgumentException("Profile login should not be null");
        }

        if (this.login.isBlank()) {
            throw new IllegalArgumentException("Profile login should not be blank");
        }

        if (this.login.length() < 3) {
            throw new IllegalArgumentException("Profile login should be at least 3 characters");
        }

        if (this.followed == null) {
            throw new IllegalArgumentException("Profile followed should not be null");
        }
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the followed
     */
    public Map<String, Profile> getFollowed() {
        return followed;
    }

    public void follow(final Profile aFollowed) {
        this.followed.put(aFollowed.getId(), aFollowed);
    }

    public void unfollow(final Profile aFollowed) {
        this.followed.remove(aFollowed.getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Profile other = (Profile) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
