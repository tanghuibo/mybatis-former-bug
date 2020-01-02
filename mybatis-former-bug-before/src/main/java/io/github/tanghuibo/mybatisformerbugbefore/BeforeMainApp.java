package io.github.tanghuibo.mybatisformerbugbefore;

import io.github.tanghuibo.mybatisformerbugcore.service.TestService;

import java.io.IOException;

/**
 * @author tanghuibo
 * @date 2020/1/3上午12:50
 */
public class BeforeMainApp {

    public static void main(String[] args) throws IOException {
        TestService testService = new TestService();

        testService.test();
    }
}
