package com.techdes.archery.repository;

import com.techdes.archery.entity.Range;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface RangeRepository extends BaseRepository<Integer, Range> {
    List<Range> findAll();
}
