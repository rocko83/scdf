package br.com.clusterlab.sinklog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
//import lombok.extern.slf4j.Slf4j;


//@Slf4j
@EnableBinding(Sink.class)
@SpringBootApplication
public class SinkLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinkLogApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
//    public void loggerSink(String date) {
//        log.info("Received: " + date);
//    }
    public void loggerSink(String date) {
        System.out.println(date.toString());
    }
}
