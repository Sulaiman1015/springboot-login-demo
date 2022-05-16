package com.springboot.logindemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class WebApplication {

  public static void main(String[] args) throws UnknownHostException {
    ConfigurableApplicationContext application = SpringApplication.run(WebApplication.class, args);

    Environment env = application.getEnvironment();
    String ip = InetAddress.getLocalHost().getHostAddress();
    String port = env.getProperty("server.port");
    String path = env.getProperty("server.servlet.context-path");
    if (!StringUtils.hasText(path)) {
      path = "";
    }
    log.info("\n----------------------------------------------------------\n\t" +
            "Application  is running! Access URLs:\n\t" +
            "Local url: \t\thttp://localhost:" + port + path + "\n\t" +
            "External url: \thttp://" + ip + ":" + port + path + "\n\t" +
            "----------------------------------------------------------");
    String jvmName = ManagementFactory.getRuntimeMXBean().getName();
    log.info("Current project process number：" + jvmName.split("@")[0]);
  }

}
