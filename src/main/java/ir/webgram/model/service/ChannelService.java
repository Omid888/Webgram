package ir.webgram.model.service;

import ir.webgram.model.dto.Channel;
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

    public Channel find(Integer id){
        ChannelEntity entity = channelRepository.findById(id).get();

        Channel channel = new Channel();
        channel.setId(entity.getId());
        channel.setName(entity.getName());
        channel.setDate(entity.getDate());

        return channel;
    }

    public List<Channel> findByCreatorId(Integer userId){
        List<Channel> channels = null;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);

        List<ChannelEntity> list = channelRepository.findByCreator(userEntity);

        if (!list.isEmpty()){
            channels = new ArrayList<>();
            for (ChannelEntity e : list){
                Channel channel = new Channel();
                channel.setId(e.getId());
                channel.setName(e.getName());
                channel.setDate(e.getDate());

                channels.add(channel);
            }
        }
        return channels;
    }
}
