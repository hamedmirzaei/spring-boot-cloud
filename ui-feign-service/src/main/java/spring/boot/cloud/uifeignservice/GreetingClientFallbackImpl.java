package spring.boot.cloud.uifeignservice;

import org.springframework.stereotype.Component;

@Component
public class GreetingClientFallbackImpl implements GreetingClient {
    @Override
    public String greeting() {
        return "Service is not available";
    }
}
