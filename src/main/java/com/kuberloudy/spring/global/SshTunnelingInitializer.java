package com.kuberloudy.spring.global;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Properties;

import static java.lang.System.exit;

@ConfigurationProperties(prefix = "ssh")
@Slf4j
@Component
@Validated @Setter
public class SshTunnelingInitializer {

    private String remoteJumpHost;
    private String user;
    private int sshPort;
    private String privateKey;
    private int databasePort;

    private Session session;

    @PreDestroy
    public void closeSSH() {
        if (session.isConnected()){
            session.disconnect();}
    }

    public Integer buildSshConnection() {

        Integer forwardedPort = null;

        try {
            log.info("{}@{}:{}:{} with privateKey",user, remoteJumpHost, sshPort, databasePort);

            log.info("start ssh tunneling..");
            JSch jSch = new JSch();

            log.info("creating ssh session");
            jSch.addIdentity(privateKey);
            log.info("successfully set identity using local file");
            session = jSch.getSession(user, remoteJumpHost, sshPort);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            log.info("complete creating ssh session");

            log.info("start connecting ssh connection");
            session.connect();
            log.info("success connecting ssh connection");

            log.info("start forwarding");
            forwardedPort = session.setPortForwardingL(0,"10.0.1.177",3306);
            log.info("successfully connected to database");

        } catch (JSchException e){
            log.error("fail to make ssh tunneling");
            this.closeSSH();
            e.printStackTrace();
            exit(1);
        }

        return forwardedPort;
    }



}
