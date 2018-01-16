package ir.webgram.model.entity.relation.favorite;

import ir.webgram.model.entity.PostEntity;
import ir.webgram.model.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Saeed on 1/16/2018.
 */

@Entity
@Table(name = "favorite_tb")
public class Favorite {

    @EmbeddedId
    private FavoriteId id;

    @ManyToOne
    @MapsId("userId")
    private UserEntity user;

    @ManyToOne
    @MapsId("postId")
    private PostEntity post;

    @Column(name = "date")
    private Date date;

    public FavoriteId getId() {
        return id;
    }

    public void setId(FavoriteId id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
