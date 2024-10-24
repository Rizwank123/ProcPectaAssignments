package com.procpecta.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procpecta.dev.domain.Product;
import com.procpecta.dev.services.ProductService;


//import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/products")
//@Tag(name="Task Manager",description = " end points")
public class ProductController {
	@Autowired
	private ProductService ps;

	@GetMapping("/category/{cat}")
	public ResponseEntity <List<Product>> getProduct(@PathVariable String cat) throws Exception{
		 return ResponseEntity.ok(ps.GetProductByCategory(cat));
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Product> CreateProduct(@RequestBody Product in) throws Exception {
		Product prod = ps.CreateProduct(in);
		in.setId(prod.getId());
		return new ResponseEntity<>(in, HttpStatus.CREATED);
	}

}
