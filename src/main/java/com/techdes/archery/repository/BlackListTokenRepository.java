package com.techdes.archery.repository;

import com.techdes.archery.entity.BlackListToken;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BlackListTokenRepository extends BaseRepository<Long, BlackListToken> {
}
