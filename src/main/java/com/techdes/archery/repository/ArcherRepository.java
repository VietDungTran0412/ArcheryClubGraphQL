package com.techdes.archery.repository;

import com.techdes.archery.entity.Archer;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface ArcherRepository extends BaseRepository<Integer, Archer> {
    Optional<Archer> loadById(Integer id);
//    private List<Archer> search
}
