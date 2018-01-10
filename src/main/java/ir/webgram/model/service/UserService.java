package ir.webgram.model.service;

import ir.webgram.model.dto.Login;
import ir.webgram.model.dto.Post;
import ir.webgram.model.dto.Signup;
import ir.webgram.model.dto.User;
import ir.webgram.model.entity.PostEntity;
import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.repository.PostRepository;
import ir.webgram.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Saeed on 12/23/2017.
 */

@Service("testService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelService channelService;

    public User save(Signup signup){
        UserEntity userEntity = new UserEntity();

        userEntity.setName(signup.getName());
        userEntity.setUsername(signup.getUsername());
        userEntity.setPassword(signup.getPassword());
        userEntity.setDate(new Date());

        UserEntity entity = userRepository.save(userEntity);

        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());

        return user;
    }

    public User find(Login login){
        // TODO: 1/5/2018 I wanna an user entity not list of that
        List<UserEntity> list = userRepository
                .findByUsernameAndPassword(login.getUsername(), login.getPassword());
        if (list.isEmpty())
            return null;

        UserEntity userEntity = list.get(0);

        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());

        return user;
    }

    public Boolean exist(String username){
        return userRepository.findByUsername(username)!=null;
    }
}
