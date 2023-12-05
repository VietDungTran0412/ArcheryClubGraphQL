package com.techdes.archery.service.impl;

import com.techdes.archery.entity.Range;
import com.techdes.archery.repository.RangeRepository;
import com.techdes.archery.service.RangeService;
import org.springframework.stereotype.Service;

@Service
public class RangeServiceImpl extends BaseServiceImpl<Integer, Range, RangeRepository> implements RangeService {
    protected RangeServiceImpl(RangeRepository repository) {
        super(repository);
    }
}
