package ir.webgram.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Saeed on 12/21/2017.
 */

public class Channel {

    private Integer id;
    private String name;

    private Date date;

    private User creator;

    private List<Post> posts;

    public Channel() {
        posts = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
