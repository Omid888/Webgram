package ir.webgram.model.repository;

import ir.webgram.model.entity.ChannelEntity;
import ir.webgram.model.entity.PostEntity;
import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.repository.custom.PostRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Saeed on 12/23/2017.
 */
public interface PostRepository extends JpaRepository<PostEntity, Integer>, CrudRepository<PostEntity, Integer>, PostRepositoryCustom{

    @Transactional
    PostEntity save(PostEntity post);

    @Transactional(readOnly = true)
    List<PostEntity> findAllByWriter(UserEntity user);

    @Transactional(readOnly = true)
    List<PostEntity> findAllByChannel(ChannelEntity channelEntity);

    @Transactional(readOnly = true)
    @Query(value = "SELECT p FROM PostEntity p where p.channel = :ch order by p.date desc ")
    Page<PostEntity> findAllByChannel(@Param("ch")ChannelEntity channel, Pageable pageable);
}
