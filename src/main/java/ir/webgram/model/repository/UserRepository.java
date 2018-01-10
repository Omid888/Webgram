package ir.webgram.model.repository;

import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.repository.custom.UserRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Saeed on 12/23/2017.
 */

public interface UserRepository extends CrudRepository<UserEntity, Integer>, UserRepositoryCustom {


    @Transactional
    UserEntity save(UserEntity entity);

    @Transactional(readOnly = true)
    UserEntity findByUsername(String username);

    @Transactional(readOnly = true)
    List<UserEntity> findByUsernameAndPassword(String username, String password);

    // TODO: 1/5/2018 Pagination of users
    Page<UserEntity> findAll(Pageable pageable);
}
