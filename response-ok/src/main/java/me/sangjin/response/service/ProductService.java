package me.sangjin.response.service;

import lombok.RequiredArgsConstructor;
import me.sangjin.response.domain.Product;
import me.sangjin.response.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(String name) {
        Optional<Product> productByName = productRepository.findByName(name);
        if(productByName.isPresent()) {
            // exception 커스터마이징 필요
            throw new RuntimeException();
        }

        Product product = new Product();
        product.setName(name);

        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void updateProduct(Long id, String name) {

        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); // exception 커스터마이징 필요

        productById.setName(name);
        productRepository.save(productById);

    }

    public void deleteProduct(Long id) {

        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); // exception 커스터마이징 필요

        productRepository.delete(productById); // 삭제 컬럼을 두는 것을 추천. (실 운영에서 실제 삭제하는 경우 없음.)
    }
}
