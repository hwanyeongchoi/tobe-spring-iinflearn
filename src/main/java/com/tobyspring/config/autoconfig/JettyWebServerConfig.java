package com.tobyspring.config.autoconfig;

import com.tobyspring.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

@MyAutoConfiguration
/*
    JettyWebServerConfig를 ConFiguration class Bean으로 등록할 것인지 스프링 컨테이너에게 알려주는 애노테이션
    @Conditional에는 Condition의 구현체 클래스를 알려줘야 합니다. Condition에는 matches라는 메소드가 있는데
    해당 메소드를 통해 Bean 등록 여부를 결정합니다.
 */

@Conditional(JettyWebServerConfig.JettyCondition.class)
public class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

    static class JettyCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }

}