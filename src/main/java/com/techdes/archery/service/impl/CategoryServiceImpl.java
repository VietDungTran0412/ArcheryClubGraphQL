package com.techdes.archery.service.impl;

import com.techdes.archery.entity.Category;
import com.techdes.archery.repository.CategoryRepository;
import com.techdes.archery.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Integer, Category, CategoryRepository> implements CategoryService {
    protected CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }
}
