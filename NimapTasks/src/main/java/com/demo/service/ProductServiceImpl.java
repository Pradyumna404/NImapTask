package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao pd;

	@Override
	public Page<Product> findAll(Pageable p) {
		return pd.findAll(p);
	}

	@Override
	public Product save(Product p) {
		return pd.save(p);
	}

	@Override
	public void deleteByDi(int di) {
		pd.deleteById(di);
	}

	@Override
	public Product findByDi(int di) {
		return pd.findById(di).orElseThrow();
	}

	@Override
	public Product update(int di, Product p) {
		Product p2=pd.findById(di).orElseThrow();
		p2.setName(p.getName());
		p2.setPrice(p.getPrice());
		p2.setCategory(p.getCategory());
		return pd.save(p2);
	}

}

