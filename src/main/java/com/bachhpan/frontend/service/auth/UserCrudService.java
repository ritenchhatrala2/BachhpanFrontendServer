package com.bachhpan.frontend.service.auth;

import com.bachhpan.frontend.model.User;

import java.util.Optional;

/**
 * User security operations like login and logout, and CRUD operations on {@link User}.
 * https://octoperf.com/blog/2018/03/08/securing-rest-api-spring-security/
 * @author jerome
 *
 */
public interface UserCrudService {

    User save(User user);

    Optional<User> find(String id);

    Optional<User> findByUsername(String username);
}
