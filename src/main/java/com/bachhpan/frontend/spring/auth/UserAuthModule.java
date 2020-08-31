package com.bachhpan.frontend.spring.auth;

import com.bachhpan.frontend.service.auth.InMemoryUsers;
import com.bachhpan.frontend.service.auth.UserCrudService;
import com.bachhpan.frontend.utils.date.DateService;
import com.bachhpan.frontend.utils.date.JodaDateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.joda.time.DateTimeZone.UTC;

@Configuration
public class UserAuthModule {

    @Bean(name="JodaDateService") DateService dateService() { return new JodaDateService(UTC); }

    @Bean("UserCrudService") UserCrudService userCrudService() {
        return new InMemoryUsers();
    }
}
