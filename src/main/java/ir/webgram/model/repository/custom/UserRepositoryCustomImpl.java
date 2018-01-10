package ir.webgram.model.repository.custom;

import ir.webgram.model.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Saeed on 1/5/2018.
 */
public class UserRepositoryCustomImpl implements UserRepositoryCustom {


    @Override
    @Transactional
    public List<UserEntity> findAllByPagination() {
        return null;
    }
}
