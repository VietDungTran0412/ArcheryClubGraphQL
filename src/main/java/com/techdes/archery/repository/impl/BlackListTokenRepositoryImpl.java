package com.techdes.archery.repository.impl;

import com.techdes.archery.entity.BlackListToken;
import com.techdes.archery.repository.BlackListTokenRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BlackListTokenRepositoryImpl extends BaseRepositoryImpl<Long, BlackListToken> implements BlackListTokenRepository {
    protected BlackListTokenRepositoryImpl(EntityManager em) {
        super(BlackListToken.class, em);
    }
}
