package com.orders.ordermnagement.principal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.orders.ordermnagement.models.Category;
import com.orders.ordermnagement.models.Product;
import com.orders.ordermnagement.models.ProductDto;
import com.orders.ordermnagement.repository.CategoryRepository;
import com.orders.ordermnagement.repository.ProductRepository;
import com.orders.ordermnagement.services.Converter;
import com.orders.ordermnagement.services.PlatziProductApi;
import org.springframework.dao.DataIntegrityViolationException;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private ProductRepository repository;
    private CategoryRepository ctgRepository;
    private Converter cvs = new Converter();
    private Scanner sc = new Scanner(System.in);
    private final String ADRESS = "https://api.escuelajs.co/api/v1/products";
    private List<Product> products = new ArrayList<>();

    public Principal(ProductRepository repository, CategoryRepository ctgRepository){
        this.repository = repository;
        this.ctgRepository = ctgRepository;
    }

    public void showMenu(){
        String json = PlatziProductApi.getJsonData(ADRESS);

        String menu = """
				0. Exit
				1. Add product to your personal list
				2. List all products at your list
				>
				""";

        int option = -1;

        while(option != 0){
            System.out.println(menu);
            option = Integer.parseInt(sc.nextLine());

            if(option == 0){
                break;
            }

            switch (option){
                case 1: addProduct();
                break;
                case 2: listAllProducts();
                break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }

    private void listAllProducts() {
    }

    private void addProduct() {
        Product product = getProductData();

        if (product == null) {
            System.out.println("No product selected.");
            return;
        }

        Category managedCategory = saveOrGetCategory(product.getCategory());
        product.setCategory(managedCategory);

        repository.save(product);
        System.out.println("Product added successfully.");
    }

    private Category saveOrGetCategory(Category category) {
        Optional<Category> existingCategory = ctgRepository.findByName(category.getName());

        if (existingCategory.isPresent()) {
            return existingCategory.get();
        }

        try {
            return ctgRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Category already exists, fetching existing one...");
            return ctgRepository.findByName(category.getName())
                    .orElseThrow(() -> new RuntimeException("Unexpected error: category not found after save failure"));
        }
    }


    private Product getProductData() {
        try {
            if (products.isEmpty()) {
                String json = PlatziProductApi.getJsonData(ADRESS);
                List<ProductDto> productDtoList = cvs.getDataList(json, new TypeReference<List<ProductDto>>() {});
                products = productDtoList.stream()
                        .map(data -> new Product(data))
                        .collect(Collectors.toList());
            }

            for(int i = 0; i < products.size(); i++){
                System.out.println((i+1)+" - "+products.get(i).getTitle());
            }
            System.out.println("Enter product id to add into list: ");
            int pId = Integer.parseInt(sc.nextLine());

            if(pId < 0 || pId > products.size()){
                System.out.println("Invalid Selection.");
                return null;
            }

            return products.get(pId-1);
        } catch (Exception e) {
            System.out.println("Product Data Error: " + e.getMessage());
            return null;
        }
    }

}
