package com.masai;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Presentation {

	@Autowired
	private ProductService pService;

	public void insertProduct() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter product details");

		System.out.println("Enter Product name");
		String name = sc.nextLine();

		System.out.println("Enter quantity");
		int quantiry = sc.nextInt();

		System.out.println("Enter price");
		int price = sc.nextInt();

		Product p = new Product();
		p.setPrice(price);
		p.setQuantity(quantiry);
		p.setProductName(name);

		boolean value = pService.addProduct(p);
		if (value) {
			System.out.println("Product added");
		} else {
			System.out.println("Not added");
		}

	}

	public void printAllProduct() {

		List<Product> plist = pService.getAllProducts();
		
		plist.forEach( p-> {
			System.out.println(p);
		});

	}

	public void searchProduct(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter productId to search");
		
		int id = sc.nextInt();
		
		Product p;
		try {
			p = pService.getProductById(id);
			
			System.out.println(p);
			
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
		}

	public void GetProductsWithingPriceRange() {
		// take the price range (fromPrice and toPrice) from the user and call
		// the appropriate method on //pService object and print the Product
		// within the price range,
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter fromPrice");
		
		int fromPrice = sc.nextInt();
		
		System.out.println("Enter toPrice");
		
		int toPrice = sc.nextInt();
		
		List<Product> list;
		try {
			list = pService.getProductsBetweenPrice(fromPrice, toPrice);
			list.forEach(p-> {
				System.out.println(p);
			});
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

}
