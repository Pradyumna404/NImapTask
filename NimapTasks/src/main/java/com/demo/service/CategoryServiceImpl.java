package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CategoryDao;
import com.demo.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao cd;
	
	@Override
	public Page<Category> findAll(Pageable p) {
		return cd.findAll(p);
	}
	
	@Override
	public Category save(Category c) {
		return cd.save(c);
	}

	@Override
	public Category findByDi(int di) {
		return cd.findById(di).orElseThrow();
	}

	@Override
	public void deleteByDi(int di) {
		cd.deleteById(di);
	}

	@Override
	public Category update(int di, Category c) {
		Category c2=cd.findById(di).orElseThrow();
		c2.setName(c.getName());
		c2.setDescription(c.getDescription());
		c2.setProducts(c.getProducts());
		return cd.save(c2);
	}


}
