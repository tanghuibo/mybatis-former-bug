package io.github.tanghuibo.mybatisformerbugafter;

import io.github.tanghuibo.mybatisformerbugcore.service.TestService;

import java.io.IOException;

/**
 * @author tanghuibo
 * @date 2020/1/3上午12:50
 */
public class AfterMainApp {

    public static void main(String[] args) throws IOException {
        TestService testService = new TestService();

        testService.test();
    }
}
