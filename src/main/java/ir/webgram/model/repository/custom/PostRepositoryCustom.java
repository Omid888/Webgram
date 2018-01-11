package ir.webgram.model.repository.custom;

import ir.webgram.model.entity.PostEntity;
import ir.webgram.model.entity.UserEntity;

import java.util.List;

/**
 * Created by Saeed on 1/11/2018.
 */
public interface PostRepositoryCustom {

    List<PostEntity> getFeed(UserEntity userEntity);
}
