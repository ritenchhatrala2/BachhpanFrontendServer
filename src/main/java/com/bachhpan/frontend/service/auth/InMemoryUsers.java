package com.bachhpan.frontend.service.auth;

import com.bachhpan.frontend.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class InMemoryUsers implements UserCrudService {

    static Map<String, User> users = new HashMap<>();

    static {
        users.put("admin", new User("admin", "admin", "admin"));
    }

    @Override
    public User save(final User user) {
        return users.put(user.getId(), user);
    }

    @Override
    public Optional<User> find(final String id) {
        return ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return users
                .values()
                .stream()
                .filter(u -> Objects.equals(username, u.getUsername()))
                .findFirst();
    }
}
