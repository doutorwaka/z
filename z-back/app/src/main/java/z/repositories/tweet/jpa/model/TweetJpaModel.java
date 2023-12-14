package z.repositories.tweet.jpa.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import z.repositories.profile.jpa.model.ProfileJpaModel;

@Entity(name = "Tweet")
@Table(name = "tweets")
public class TweetJpaModel {

    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    private String id;
    @Column(name = "content", nullable = false)
    private String content;
    @ManyToOne(targetEntity = ProfileJpaModel.class, optional = false, fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false),
            @JoinColumn(name = "author_login", referencedColumnName = "login", nullable = false)
    })
    private ProfileJpaModel author;
    @Column(name = "likes", nullable = false)
    private int likes;
    @Column(name = "views", nullable = false)
    private int views;
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    /**
     * 
     */
    public TweetJpaModel() {
    }

    /**
     * @param id
     * @param content
     * @param author
     * @param likes
     * @param views
     * @param createdAt
     */
    public TweetJpaModel(String id, String content, ProfileJpaModel author, int likes, int views, Instant createdAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likes = likes;
        this.views = views;
        this.createdAt = createdAt;
    }

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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the author
     */
    public ProfileJpaModel getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(ProfileJpaModel author) {
        this.author = author;
    }

    /**
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * @param likes the likes to set
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * @return the views
     */
    public int getViews() {
        return views;
    }

    /**
     * @param views the views to set
     */
    public void setViews(int views) {
        this.views = views;
    }

    /**
     * @return the createdAt
     */
    public Instant getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
