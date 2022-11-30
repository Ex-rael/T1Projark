package com.projark.trab.Dominio.Servicos.Microservicos;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebAccountService {

    @Autowired
    @LoadBalanced

    protected RestTemplate restTemplate;

    protected String serviceUrl;

    public WebAccountService(WebAccountService webAccountService) {
        this.serviceUrl = webAccountService.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    public Account getByNumber(String accountNumber) {
        Account account = restTemplate.getForObject(serviceUrl
                + "/accounts/{number}", Account.class, accountNumber);

        if (account == null)
            throw new AccountNotFoundException(accountNumber);
        else
            return account;
    }

}
