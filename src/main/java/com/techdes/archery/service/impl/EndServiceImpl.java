package com.techdes.archery.service.impl;

import com.techdes.archery.entity.End;
import com.techdes.archery.repository.EndRepository;
import com.techdes.archery.service.EndService;
import org.springframework.stereotype.Service;

@Service
public class EndServiceImpl extends BaseServiceImpl<Long, End, EndRepository> implements EndService {
    protected EndServiceImpl(EndRepository repository) {
        super(repository);
    }
}
