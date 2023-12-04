package org.apache.dubbo.provider;

import org.apache.dubbo.api.GreetingsService;

public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayHi(String name) {
        return "hi" + name;
    }

}
