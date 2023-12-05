package com.techdes.archery.repository;

import com.techdes.archery.entity.End;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EndRepository extends BaseRepository<Long, End> {
}
