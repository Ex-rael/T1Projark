package com.projark.trab.Dominio.Servicos.Microservicos;

import javax.security.auth.login.AccountException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(AccountException.class)
public class AccountsServer {

    @Autowired
    AuditEventRepository accountRepository;

    public static void main(String[] args) {
        // Will configure using accounts-server.yml
        System.setProperty("spring.config.name", "accounts-server");

        SpringApplication.run(AccountsServer.class, args);
    }
}