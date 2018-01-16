package ir.webgram.model.repository;

import ir.webgram.model.entity.ChannelEntity;
import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.entity.relation.membership.Membership;
import ir.webgram.model.entity.relation.membership.MembershipId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Saeed on 12/24/2017.
 */
public interface MembershipRepository extends CrudRepository<Membership, MembershipId> {

    @Transactional
    Membership save(Membership membership);

    @Transactional(readOnly = true)
    @Query("select m from Membership m where m.user = :user")
    List<Membership> findByUser(@Param(value = "user")UserEntity user);

    @Transactional(readOnly = true)
    Long countAllByChannelId(Integer channelId);

    @Transactional(readOnly = true)
    @Query("select count(e) from Membership e where e.user = :user and e.channel = :channel")
    Long isExists(@Param(value = "user") UserEntity user, @Param(value = "channel")ChannelEntity channel);
}
