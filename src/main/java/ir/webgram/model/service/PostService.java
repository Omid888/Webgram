package ir.webgram.model.service;

import ir.webgram.model.dto.Post;
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

    public List<Post> findByChannelId(Integer channelId){
        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setId(channelId);

        List<PostEntity> list = postRepository.findAllByChannel(channelEntity);

        if (list.isEmpty())
            return null;

        List<Post> posts = new ArrayList<>();
        for (PostEntity e:list){
            Post p = new Post();
            p.setId(e.getId());
            p.setTitle(e.getTitle());
            p.setContent(e.getContent());
            p.setUrl(e.getUrl());
            p.setImageUrl(e.getImageUrl());
            p.setDate(e.getDate());
            p.setWriterName(e.getWriter().getName());

            posts.add(p);
        }

        return posts;
    }

    public List<Post> findByChannelId(Integer channelId, Integer pageStart, Integer limit){
        Pageable pageable = new PageRequest(pageStart, limit);

        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setId(channelId);

        Page<PostEntity> page = postRepository.findAllByChannel(channelEntity, pageable);
        List<PostEntity> list = page.getContent();

        if (list.isEmpty())
            return null;

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

            posts.add(p);
        }

        return posts;
    }


}
