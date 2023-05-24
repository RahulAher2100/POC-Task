package userservice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.user.entity.User;
import userservice.user.repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {

        return this.userRepository.getByUserId(userId);

    }
}
