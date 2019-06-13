package spring.boot.cloud.camelservice;

import org.apache.camel.Exchange;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class CamelServiceApplication extends SpringRouteBuilder {

    public static void main(String[] args) {
        SpringApplication.run(CamelServiceApplication.class, args);
    }

    @Override
    public void configure() throws Exception {
        from("jetty:http://localhost:8769/start")
                .removeHeader("CamelHttp*")
                .setHeader("Content-Type", constant("application/json"))
                .setHeader("Accept", constant("application/json"))
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .log("Start service")
                .serviceCall("spring-cloud-eureka-client/customers")
                .log("Done ${body}")
                .end();

    }
}
