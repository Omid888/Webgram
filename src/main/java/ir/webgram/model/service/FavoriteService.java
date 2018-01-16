package ir.webgram.model.service;

import ir.webgram.model.entity.PostEntity;
import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.entity.relation.favorite.Favorite;
import ir.webgram.model.entity.relation.favorite.FavoriteId;
import ir.webgram.model.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Saeed on 1/16/2018.
 */

@Service("favoriteService")
public class FavoriteService {

    @Autowired
    private FavoriteRepository repository;

    public Boolean like(Integer userId, Integer postId){
        UserEntity user = new UserEntity();
        user.setId(userId);

        PostEntity post = new PostEntity();
        post.setId(postId);

        FavoriteId id = new FavoriteId();
        id.setUserId(userId);
        id.setPostId(postId);

        Favorite favorite = new Favorite();
        favorite.setId(id);
        favorite.setUser(user);
        favorite.setPost(post);
        favorite.setDate(new Date());

        repository.save(favorite);

        return Boolean.TRUE;
    }

    public Integer likes(PostEntity post){
        return Integer.parseInt(repository.countAllByPostId(post.getId()).toString());
    }
}
