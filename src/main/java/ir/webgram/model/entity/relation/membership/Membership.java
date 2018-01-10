package ir.webgram.model.entity.relation.membership;

import ir.webgram.model.entity.ChannelEntity;
import ir.webgram.model.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Saeed on 12/24/2017.
 */

@Entity
@Table(name = "membership_tb")
public class Membership {

    @EmbeddedId
    private MembershipId id;

    @ManyToOne
    @MapsId("userId")
    private UserEntity user;

    @ManyToOne
    @MapsId("channelId")
    private ChannelEntity channel;

    @Column(name = "writer")
    private Boolean writer;

    @Column(name = "date")
    private Date date;

    public Membership() {
    }

    public MembershipId getId() {
        return id;
    }

    public void setId(MembershipId id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ChannelEntity getChannel() {
        return channel;
    }

    public void setChannel(ChannelEntity channel) {
        this.channel = channel;
    }

    public Boolean getWriter() {
        return writer;
    }

    public void setWriter(Boolean writer) {
        this.writer = writer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
