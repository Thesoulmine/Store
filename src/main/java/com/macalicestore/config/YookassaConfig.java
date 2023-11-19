package com.macalicestore.config;

import net.suuft.yookassa.Yookassa;
import net.suuft.yookassa.YookassaInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class YookassaConfig {

    @Bean
    public Yookassa yookassa() {
        return YookassaInitializer.initializeSdk(322550,
                "test_ZJgFNaxWAxmCk4TW9ks6Up8M-cJOC8yt73UZcA-y7sc");
    }
}
