package com.techdes.archery.repository.impl;

import com.techdes.archery.entity.Equipment;
import com.techdes.archery.repository.EquipmentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EquipmentRepositoryImpl extends BaseRepositoryImpl<Integer, Equipment> implements EquipmentRepository {
    protected EquipmentRepositoryImpl(EntityManager em) {
        super(Equipment.class, em);
    }
}
