package ir.webgram.model.repository.custom;

import ir.webgram.model.entity.PostEntity;
import ir.webgram.model.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Saeed on 1/11/2018.
 */
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<PostEntity> getFeed(UserEntity userEntity) {

        List<PostEntity> list = em.createQuery("select p from Membership m, PostEntity p where m.user = :user and p.channel = m.channel order by p.date desc ")
//        List<PostEntity> list = em.createQuery("select p from PostEntity p where p.writer = :user order by p.date desc ")
                .setParameter("user", userEntity)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();
        return list;
    }
}
