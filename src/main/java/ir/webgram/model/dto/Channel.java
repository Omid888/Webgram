package ir.webgram.model.dto;

import java.util.Date;

/**
 * Created by Saeed on 12/21/2017.
 */

public class Channel {

    private Integer id;
    private String name;

    private Date date;

    private User creator;

    private Integer members;
    private Integer postsNumber;
    private Boolean joined;


    public Channel() {
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

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Integer getPostsNumber() {
        return postsNumber;
    }

    public void setPostsNumber(Integer postsNumber) {
        this.postsNumber = postsNumber;
    }

    public Boolean getJoined() {
        return joined;
    }

    public void setJoined(Boolean joined) {
        this.joined = joined;
    }
}
