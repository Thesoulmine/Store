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
        return YookassaInitializer.initializeSdk(443459,
                "test_oD07lKe-3MIYWNtfXOlW4twejwxyDiH8QMICi3mmPlU");
    }
}
