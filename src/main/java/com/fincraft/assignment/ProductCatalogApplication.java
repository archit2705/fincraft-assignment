package com.fincraft.assignment;

import com.fincraft.assignment.dtos.ProductDto;
import com.fincraft.assignment.dtos.UserDto;
import com.fincraft.assignment.services.ProductService;
import com.fincraft.assignment.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(UserService userService, ProductService productService) {
		return args -> {
			// Adding demo data for users
			userService.saveUser(
					UserDto.builder().name("John Smith").username("john_smith").email("john.smith@example.com").password("password123").build()
			);
			userService.saveUser(
					UserDto.builder().name("Emma Johnson").username("emma_j").email("emma.johnson@example.com").password("password456").build()
			);

			// Adding demo data for products
			productService.createProduct(
					ProductDto.builder().name("Laptop").description("Powerful laptop with high-resolution display").inventory(50).price(1299.99)
							.brand("TechCorp").imageUrl("laptop_image.jpg").build()
			);
			productService.createProduct(
					ProductDto.builder().name("Smartphone").description("Latest smartphone with advanced features").inventory(100).price(799.99)
							.brand("MobileTech").imageUrl("phone_image.jpg").build()
			);
			productService.createProduct(
					ProductDto.builder().name("Wireless Headphones").description("Over-ear headphones with noise cancellation").inventory(30)
							.price(199.99).brand("AudioTech").imageUrl("headphones_image.jpg").build()
			);
			productService.createProduct(
					ProductDto.builder().name("4K Smart TV").description("Ultra HD television with smart functionality").inventory(20)
							.price(1499.99).brand("HomeTech").imageUrl("tv_image.jpg").build()
			);
			productService.createProduct(
					ProductDto.builder().name("Coffee Maker").description("Automatic coffee maker with programmable timer").inventory(40)
							.price(89.99).brand("KitchenTech").imageUrl("coffee_maker_image.jpg").build()
			);
			productService.createProduct(
					ProductDto.builder().name("Fitness Tracker").description("Waterproof fitness tracker with heart rate monitor").inventory(60)
							.price(49.99).brand("HealthTech").imageUrl("tracker_image.jpg").build()
			);
			productService.createProduct(
					ProductDto.builder().name("Gaming Laptop").description("High-performance laptop for gaming enthusiasts").inventory(15)
							.price(1999.99).brand("GamingTech").imageUrl("gaming_laptop_image.jpg").build()
			);
			productService.createProduct(
					ProductDto.builder().name("Digital Camera").description("Mirrorless camera with 24MP sensor").inventory(25)
							.price(899.99).brand("PhotoTech").imageUrl("camera_image.jpg").build()
			);
			productService.createProduct(
					ProductDto.builder().name("Home Security Camera").description("Wireless security camera with night vision").inventory(35)
							.price(129.99).brand("SecurityTech").imageUrl("security_camera_image.jpg").build()
			);
			productService.createProduct(
					ProductDto.builder().name("Bluetooth Speaker").description("Portable speaker with 20W output").inventory(50)
							.price(79.99).brand("AudioTech").imageUrl("speaker_image.jpg").build()
			);
		};
	}


}
