package z.repositories.profile.jpa.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Profile")
@Table(name = "profiles")
public class ProfileJpaModel {

    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "login", unique = true, nullable = false)
    private String login;
    @ManyToMany(targetEntity = ProfileJpaModel.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(name = "profile_follow", joinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "followed_id", referencedColumnName = "id"), uniqueConstraints = {
            @UniqueConstraint(columnNames = { "follower_id", "followed_id" })
    })
    private Set<ProfileJpaModel> follows;

    public ProfileJpaModel() {

    }

    /**
     * @param id
     * @param name
     * @param email
     * @param login
     * @param follows
     * @param followed
     */
    public ProfileJpaModel(String id, String name, String email, String login, Set<ProfileJpaModel> follows,
            Set<ProfileJpaModel> followed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.follows = follows;
        this.followed = followed;
    }

    private Set<ProfileJpaModel> followed;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the followed
     */
    public Set<ProfileJpaModel> getFollowed() {
        return followed;
    }

    /**
     * @param followed the followed to set
     */
    public void setFollowed(Set<ProfileJpaModel> followed) {
        this.followed = followed;
    }

}
