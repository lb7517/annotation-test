package com.lb.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class AnnotationTestApplicationTests {

    @Test
    void contextLoads() {
        log.info("1111111");
        log.info("2222");
    }

}
