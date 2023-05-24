package userservice.user.service;

import userservice.user.entity.User;

public interface UserService {
    User add(User user);

    User getUser(Long userId);

}
