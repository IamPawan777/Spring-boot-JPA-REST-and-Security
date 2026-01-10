package com.project.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.project.dto.ProductRequest;
import com.project.dto.ProductResponce;
import com.project.entity.Product;
import com.project.repository.ProductRepository;
import com.project.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Boolean saveProduct(ProductRequest productRequest) {
		Product product = modelMapper.map(productRequest, Product.class); // mapper ...

		Product save = productRepository.save(product);
		if (ObjectUtils.isEmpty(save))
			return false;
		return true;
	}

	@Override
	public List<ProductResponce> getAllProduct() {
		List<Product> list = productRepository.findAll();
		List<ProductResponce> productResponces = list.stream()
				.map(product -> modelMapper.map(product, ProductResponce.class)).collect(Collectors.toList());
		;
		return productResponces;
	}

	@Override
	public ProductResponce getProductById(Integer id) {
		Optional<Product> byId = productRepository.findById(id);

		if (byId.isPresent()) {
			Product product = byId.get();
			ProductResponce productResponce = modelMapper.map(product, ProductResponce.class);
			return productResponce;
		}
		return null;
	}

	
	
	@Override
	public Boolean deleteProduct(Integer id) {
		Optional<Product> byId = productRepository.findById(id);

		if (byId.isPresent()) {
			Product product = byId.get();
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
