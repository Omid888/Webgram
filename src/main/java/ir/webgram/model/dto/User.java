package ir.webgram.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saeed on 12/21/2017.
 */
public class User {

    private Integer id;

    private String name;

    private List<Post> posts;
    private List<Channel> channels;

    // TODO: 12/21/2017
//    private List<Post> postsLike;
//    private List<Post> postsRead;

    public User() {
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public void addChannel(Channel channel){
        channels.add(channel);
    }
}
