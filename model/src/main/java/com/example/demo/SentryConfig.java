package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.sentry.Sentry;

@Configuration
public class SentryConfig {
    @Bean
    public void initSentry() {
        Sentry.init(options -> {
            options.setDsn("YOUR_SENTRY_DSN_HERE");
            // 필요한 경우 다른 설정들도 여기에 추가해주세요.
        });
    }
}
