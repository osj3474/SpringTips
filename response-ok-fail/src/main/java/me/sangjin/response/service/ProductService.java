package me.sangjin.response.service;

import lombok.RequiredArgsConstructor;
import me.sangjin.response.domain.Product;
import me.sangjin.response.dto.ProductResponseCode;
import me.sangjin.response.exception.product.ProductAlreadyExistException;
import me.sangjin.response.exception.product.ProductNotFoundException;
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
            throw new ProductAlreadyExistException(ProductResponseCode.PRODUCT_CREATE_FAIL_ALREADY_EXIST);
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
                .orElseThrow(() -> new ProductNotFoundException(ProductResponseCode.PRODUCT_UPDATE_FAIL_NOT_FOUND));

        productById.setName(name);
        productRepository.save(productById);

    }

    public void deleteProduct(Long id) {

        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(ProductResponseCode.PRODUCT_DELETE_FAIL_NOT_FOUND));

        productRepository.delete(productById); // 삭제 컬럼을 두는 것을 추천. ===> 아닌경우도 있음.
    }
}
