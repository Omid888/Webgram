package ir.webgram.model.repository.custom;

import ir.webgram.model.entity.UserEntity;

import java.util.List;

/**
 * Created by Saeed on 1/5/2018.
 */
public interface UserRepositoryCustom {

    List<UserEntity> findAllByPagination();
}
