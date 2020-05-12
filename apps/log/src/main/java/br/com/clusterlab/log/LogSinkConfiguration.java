package br.com.clusterlab.log;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.handler.LoggingHandler;

/**
 * @author Dave Syer
 * @author Marius Bogoevici
 * @author Gary Russell
 */
@EnableBinding(Sink.class)
@EnableConfigurationProperties(LogSinkProperties.class)
public class LogSinkConfiguration {

    @Autowired
    private LogSinkProperties properties;

    @Bean
    @ServiceActivator(inputChannel = Sink.INPUT)
    public LoggingHandler logSinkHandler() {
        LoggingHandler loggingHandler = new LoggingHandler(this.properties.getLevel().name());
        loggingHandler.setExpression(this.properties.getExpression());
        loggingHandler.setLoggerName(this.properties.getName());
        return loggingHandler;
    }

}
