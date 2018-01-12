package ir.webgram.model.repository;

import ir.webgram.model.entity.ChannelEntity;
import ir.webgram.model.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Saeed on 12/24/2017.
 */

public interface ChannelRepository extends CrudRepository<ChannelEntity, Integer> {

    @Transactional
    ChannelEntity save(ChannelEntity channelEntity);

    @Transactional(readOnly = true)
    Optional<ChannelEntity> findById(Integer id);

    @Transactional(readOnly = true)
    List<ChannelEntity> findByCreator(UserEntity userEntity);

    @Transactional(readOnly = true)
//    @Query()
    List<ChannelEntity> findByNameContains(String name);
}
