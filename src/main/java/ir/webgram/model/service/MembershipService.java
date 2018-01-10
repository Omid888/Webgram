package ir.webgram.model.service;

import ir.webgram.model.dto.Channel;
import ir.webgram.model.entity.ChannelEntity;
import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.entity.relation.membership.Membership;
import ir.webgram.model.entity.relation.membership.MembershipId;
import ir.webgram.model.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Saeed on 12/24/2017.
 */

@Service("membershipService")
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    public Boolean joinChannel(UserEntity user, ChannelEntity channel){
        MembershipId id = new MembershipId();
        id.setUserId(user.getId());
        id.setChannelId(channel.getId());

        Membership membership = new Membership();
        membership.setId(id);
        membership.setUser(user);
        membership.setChannel(channel);
        membership.setDate(new Date());
        membership.setWriter(Boolean.TRUE);

        membershipRepository.save(membership);
        return true;
    }

    public Boolean joinChannel(UserEntity user, ChannelEntity channel, Boolean writer){
        MembershipId id = new MembershipId();
        id.setUserId(user.getId());
        id.setChannelId(channel.getId());

        Membership membership = new Membership();
        membership.setId(id);
        membership.setUser(user);
        membership.setChannel(channel);
        membership.setDate(new Date());
        membership.setWriter(writer);

        membershipRepository.save(membership);
        return true;
    }

    public List<Channel> findAllChannelByUserId(Integer userId){
        List<Channel> channels = new ArrayList<>();

        UserEntity u = new UserEntity();
        u.setId(userId);
        List<Membership> memberships = membershipRepository.findByUser(u);

        if (!memberships.isEmpty())
            for (Membership m : memberships) {
                Channel channel = new Channel();
                channel.setId(m.getChannel().getId());
                channel.setName(m.getChannel().getName());
                channel.setDate(m.getDate());

                channels.add(channel);
            }

        return channels;
    }
}
