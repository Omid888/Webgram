package ir.webgram.model.service;

import ir.webgram.model.dto.Channel;
import ir.webgram.model.dto.User;
import ir.webgram.model.entity.ChannelEntity;
import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Saeed on 12/24/2017.
 */

@Service("channelService")
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private MembershipService membershipService;

    @Autowired
    private PostService postService;

    public Channel save(Channel channel){
        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setName(channel.getName());
        channelEntity.setDate(new Date());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(channel.getCreator().getId());
        channelEntity.setCreator(userEntity);

        ChannelEntity entity = channelRepository.save(channelEntity);

        membershipService.joinChannel(userEntity, channelEntity);

        channel.setId(entity.getId());
        channel.setDate(entity.getDate());
        return null;
    }

    public Boolean joinChannel(User user, Channel channel, Boolean writer){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setId(channel.getId());

        return membershipService.joinChannel(userEntity, channelEntity, writer);
    }

    public Channel find(Integer id){
        ChannelEntity entity = channelRepository.findById(id).get();

        Channel channel = new Channel();
        channel.setId(entity.getId());
        channel.setName(entity.getName());
        channel.setDate(entity.getDate());

        return channel;
    }

    public List<Channel> findByMemberId(Integer userId){
        return membershipService.findAllChannelByUserId(userId);
    }

    public List<Channel> findByCreatorId(Integer userId){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);

        List<ChannelEntity> list = channelRepository.findByCreator(userEntity);

        return channels(list);
    }

    public List<Channel> findByNameContains(String name, User user){
        List<ChannelEntity> list = channelRepository.findByNameContains(name);

        List<Channel> channels = null;
        if (!list.isEmpty()){
            channels = new ArrayList<>();
            for (ChannelEntity e : list){
                Channel channel = new Channel();
                channel.setId(e.getId());
                channel.setName(e.getName());
                channel.setDate(e.getDate());

                User creator = new User();
                creator.setId(e.getCreator().getId());
                creator.setName(e.getCreator().getName());
                channel.setCreator(creator);

                channel.setMembers(membershipService.membersNumber(e.getId()));
                channel.setPostsNumber(postService.postsNumber(e.getId()));
                channel.setJoined(membershipService.isJoined(user.getId(), e.getId()));

                channels.add(channel);
            }
        }
        return channels;
    }

    private List<Channel> channels(List<ChannelEntity> list){
        List<Channel> channels = null;
        if (!list.isEmpty()){
            channels = new ArrayList<>();
            for (ChannelEntity e : list){
                Channel channel = new Channel();
                channel.setId(e.getId());
                channel.setName(e.getName());
                channel.setDate(e.getDate());

                User user = new User();
                user.setId(e.getCreator().getId());
                user.setName(e.getCreator().getName());
                channel.setCreator(user);

                channels.add(channel);
            }
        }
        return channels;
    }
}
