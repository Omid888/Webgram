package ir.webgram.model.repository;

import ir.webgram.model.entity.PostEntity;
import ir.webgram.model.entity.relation.favorite.Favorite;
import ir.webgram.model.entity.relation.favorite.FavoriteId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Saeed on 1/16/2018.
 */
public interface FavoriteRepository extends CrudRepository<Favorite, FavoriteId> {


    @Transactional
    Favorite save(Favorite favorite);

    @Transactional(readOnly = true)
    Long countAllByPost(PostEntity postEntity);

    @Transactional(readOnly = true)
    Long countAllByPostId(Integer postId);
}
