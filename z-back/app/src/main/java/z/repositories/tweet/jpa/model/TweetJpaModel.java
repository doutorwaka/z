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
    @ManyToOne(
        targetEntity = ProfileJpaModel.class,
        optional = false,
        fetch = FetchType.EAGER
    )
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

}
