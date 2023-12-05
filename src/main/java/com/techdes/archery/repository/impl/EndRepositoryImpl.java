package com.techdes.archery.repository.impl;

import com.techdes.archery.entity.End;
import com.techdes.archery.repository.EndRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EndRepositoryImpl extends BaseRepositoryImpl<Long, End> implements EndRepository {
    protected EndRepositoryImpl(EntityManager em) {
        super(End.class, em);
    }
}
