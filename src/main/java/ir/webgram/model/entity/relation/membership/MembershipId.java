package ir.webgram.model.entity.relation.membership;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Saeed on 12/24/2017.
 */

@Embeddable
public class MembershipId implements Serializable{

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "channel_id")
    private Integer channelId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
}
