package com.techdes.archery.repository.impl;

import com.techdes.archery.entity.Category;
import com.techdes.archery.entity.QCategory;
import com.techdes.archery.entity.QEquipment;
import com.techdes.archery.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CategoryRepositoryImpl extends BaseRepositoryImpl<Integer, Category> implements CategoryRepository {
    protected CategoryRepositoryImpl(EntityManager em) {
        super(Category.class, em);
    }

    @Override
    public List<Category> findAll() {
        QCategory category = QCategory.category;
        List<Category> categories = queryFactory.selectFrom(category).distinct()
                .leftJoin(category.equipments, QEquipment.equipment)
                .fetchJoin()
                .fetch();
        return categories;
    }
}
