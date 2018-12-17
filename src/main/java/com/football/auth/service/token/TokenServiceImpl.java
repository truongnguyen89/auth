package com.football.auth.service.token;

import com.football.common.model.auth.Token;
import com.football.auth.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 17-Dec-18 12:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public Token create(Token token) throws Exception {
        return tokenRepository.save(token);
    }

    @Override
    public List<Token> findByToken(String token) throws Exception {
        return tokenRepository.findByToken(token);
    }

    @Override
    public List<Token> findByStatus(int status) throws Exception {
        return tokenRepository.findByStatus(status);
    }
}
