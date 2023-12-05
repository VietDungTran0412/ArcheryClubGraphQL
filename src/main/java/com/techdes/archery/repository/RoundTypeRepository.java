package com.techdes.archery.repository;

import com.techdes.archery.entity.RoundType;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface RoundTypeRepository extends BaseRepository<Integer, RoundType> {
    @Override
    List<RoundType> findAll();
}
