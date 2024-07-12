package com.kiran.ecom_proj.controller;

import com.kiran.ecom_proj.model.Product;
import com.kiran.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String greeting(){
        return "Hello World I'm Here!";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){

        List<Product> products = service.getAllProducts();


        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = service.getProductById(id);

        if(product!= null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
            try{

                Product product1 = service.addProduct(product,imageFile);
                return new ResponseEntity<>(product1,HttpStatus.CREATED);
            }
            catch (Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){

        Product product = service.getProductById(productId);
        byte[] imageFile = product.getImageDate();
        return ResponseEntity.ok()
                        .contentType(MediaType.valueOf(product.getImageType()))
                        .body(imageFile);

    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) throws IOException {
        Product product1 = null;
        product1 = service.updateProduct(id,product,imageFile);

        if(product1 != null)
            return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to update", HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = service.getProductById(id);

        if(product != null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        }else
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){

        List<Product> products = service.searchProducts(keyword);
        System.out.println(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);


    }



}

