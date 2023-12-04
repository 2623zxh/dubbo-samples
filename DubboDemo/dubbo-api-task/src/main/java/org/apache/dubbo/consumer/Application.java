package org.apache.dubbo.consumer;

import org.apache.dubbo.api.GreetingsService;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ReferenceConfig<GreetingsService> reference = new ReferenceConfig<>();
        reference.setInterface(GreetingsService.class);

        DubboBootstrap.getInstance()
                .application("first-dubbo-consumer")
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .reference(reference);
        GreetingsService service = reference.get();
        String msg = service.sayHi("dubbo");
        System.out.println("msg = " + msg);
        System.in.read();
    }
}
