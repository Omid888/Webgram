package ir.webgram.model.service;

import ir.webgram.model.dto.Post;
import ir.webgram.model.dto.User;
import ir.webgram.model.entity.ChannelEntity;
import ir.webgram.model.entity.PostEntity;
import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Saeed on 12/24/2017.
 */

@Service("postService")
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private FavoriteService favoriteService;

    public Post save (Post post){
        PostEntity entity = new PostEntity();
        entity.setTitle(post.getTitle());
        entity.setUrl(post.getUrl());
        entity.setContent(post.getContent());
        entity.setImageUrl(post.getImageUrl());
        entity.setDate(new Date());

        ChannelEntity ce = new ChannelEntity();
        ce.setId(post.getChannelId());
        entity.setChannel(ce);

        UserEntity ue = new UserEntity();
        ue.setId(post.getWriterId());
        entity.setWriter(ue);

        PostEntity postEntity = postRepository.save(entity);
        return post;
    }

    public List<Post> findByChannelId(Integer channelId, Integer userId, Integer pageStart, Integer limit){
        // TODO: 1/11/2018 deprecated method. find an alternative
        Pageable pageable = new PageRequest(pageStart, limit);

        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setId(channelId);

        Page<PostEntity> page = postRepository.findAllByChannel(channelEntity, pageable);
        List<PostEntity> list = page.getContent();

        if (list.isEmpty())
            return null;

        return posts(list, userId);
    }

    public List<Post> getFeed(User user, Integer start, Integer size){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        List<PostEntity> list = postRepository.getFeed(userEntity, start, size);

        if (list.isEmpty())
            return null;

        return posts(list, user.getId());
    }

    private List<Post> posts(List<PostEntity> list, Integer userId){
        List<Post> posts = new ArrayList<>();
        for (PostEntity e : list){
            Post p = new Post();
            p.setId(e.getId());
            p.setTitle(e.getTitle());
            p.setContent(e.getContent());
            p.setUrl(e.getUrl());
            p.setImageUrl(e.getImageUrl());
            p.setDate(e.getDate());
            p.setWriterName(e.getWriter().getName());
            p.setChannelId(e.getChannel().getId());
            p.setChannelName(e.getChannel().getName());

            p.setLikes(favoriteService.likes(e));
            p.setLiked(favoriteService.liked(userId, e.getId()));

            posts.add(p);
        }

        return posts;
    }

    public Integer postsNumber(Integer channelId){
        return Integer.parseInt(postRepository.countAllByChannelId(channelId).toString());
    }
}
