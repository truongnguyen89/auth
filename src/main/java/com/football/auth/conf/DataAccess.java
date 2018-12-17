package com.football.auth.conf;

import com.football.auth.service.token.TokenService;
import com.football.common.model.auth.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Component
public class DataAccess {
    @Autowired
    TokenService tokenService;

    ExecutorService executorService;
    private int numThreads = 100;

    @PostConstruct
    public void init() {
        executorService = Executors.newFixedThreadPool(numThreads);
    }

    public void createToken(Token token) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    tokenService.create(token);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
