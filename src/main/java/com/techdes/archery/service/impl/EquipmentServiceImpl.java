package com.techdes.archery.service.impl;

import com.techdes.archery.entity.Equipment;
import com.techdes.archery.repository.EquipmentRepository;
import com.techdes.archery.service.EquipmentService;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl extends BaseServiceImpl<Integer, Equipment, EquipmentRepository> implements EquipmentService {
    protected EquipmentServiceImpl(EquipmentRepository repository) {
        super(repository);
    }
}
