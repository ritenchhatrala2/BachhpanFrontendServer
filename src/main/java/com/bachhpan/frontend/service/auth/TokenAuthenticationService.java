package com.bachhpan.frontend.service.auth;

import com.bachhpan.frontend.model.User;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class TokenAuthenticationService implements UserAuthenticationService {
    private static String USERNAME = "username";

    @NonNull TokenService tokens;

    @NonNull UserCrudService users;

    @Override
    public Optional<String> login(final String username, final String password) {
        return users
                .findByUsername(username)
                .filter(user -> Objects.equals(password, user.getPassword()))
                .map(user -> tokens.expiring(ImmutableMap.of(USERNAME, username)));
    }

    @Override
    public Optional<User> findByToken(final String token) {
        return Optional
                .of(tokens.verify(token))
                .map(map -> map.get(USERNAME))
                .flatMap(users::findByUsername);
    }

    @Override public void logout(final User user) {
        //TODO: Implement
    }
}
