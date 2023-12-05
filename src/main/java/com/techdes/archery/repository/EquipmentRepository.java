package com.techdes.archery.repository;

import com.techdes.archery.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface EquipmentRepository extends BaseRepository<Integer, Equipment>{

}
