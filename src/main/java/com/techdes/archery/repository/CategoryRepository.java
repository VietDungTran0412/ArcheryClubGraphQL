package com.techdes.archery.repository;

import com.techdes.archery.entity.Category;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CategoryRepository extends BaseRepository<Integer, Category> {
    List<Category> findAll();
}
