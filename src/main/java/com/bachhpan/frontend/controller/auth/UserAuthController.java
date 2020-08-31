package com.bachhpan.frontend.controller.auth;

import com.bachhpan.frontend.api.UserAuthApi;
import com.bachhpan.frontend.model.User;
import com.bachhpan.frontend.service.auth.UserAuthenticationService;
import com.bachhpan.frontend.service.auth.UserCrudService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class UserAuthController implements UserAuthApi {

    @NonNull UserAuthenticationService authentication;
    @NonNull UserCrudService users;

    @Override
    public ResponseEntity<String> register(@RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        users.save(User.builder()
                        .id(username)
                        .username(username)
                        .password(password)
                        .build()
        );

        return login(username, password);
    }

    @Override
    public ResponseEntity<String> login(@RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        String authenticationToken = authentication
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
        return ResponseEntity.ok(authenticationToken);
    }

}
