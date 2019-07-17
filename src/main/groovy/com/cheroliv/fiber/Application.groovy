package com.cheroliv.fiber

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ConfigurableApplicationContext

@Slf4j
@CompileStatic
@SpringBootApplication(scanBasePackages = "com.cheroliv.fiber")
class Application {

    static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class)
        builder.headless(false)
        ConfigurableApplicationContext context = builder.run(args)
    }

}
