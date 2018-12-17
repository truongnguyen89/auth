package com.football.auth.service.token;

import com.football.common.model.auth.Token;
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
public interface TokenService {
    Token create(Token token) throws Exception;

    List<Token> findByToken(String token) throws Exception;

    List<Token> findByStatus(int status) throws Exception;
}
