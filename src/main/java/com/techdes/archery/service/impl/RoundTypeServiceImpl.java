package com.techdes.archery.service.impl;

import com.techdes.archery.entity.RoundType;
import com.techdes.archery.repository.RoundTypeRepository;
import com.techdes.archery.service.RoundTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundTypeServiceImpl extends BaseServiceImpl<Integer, RoundType, RoundTypeRepository> implements RoundTypeService {
    protected RoundTypeServiceImpl(RoundTypeRepository repository) {
        super(repository);
    }

}
