package me.sangjin.response.api;

import lombok.RequiredArgsConstructor;
import me.sangjin.response.domain.Product;
import me.sangjin.response.dto.ProductRequestDTO;
import me.sangjin.response.dto.ProductResponseCode;
import me.sangjin.response.dto.ProductResponseDTO;
import me.sangjin.response.dto.common.ResponseDTO;
import me.sangjin.response.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // ####################################### [ 설 명 ] #######################################
    // Create, Update, Delete는 Entity관련 정보를 주는거 없이 ResponseDTO로 반환합니다.
    // Read은 ResponseDTO사용하는 대신, Entity정보 담을 DTO를 만들어서 (status나 message없이) data 바로 반환합니다.

    // 이번 패키지에는 넣지 않았지만, (헷갈림 방지)
    // API를 사용하는 측(프론트)에서 'Request가 실패' 하는 케이스를 아는 방법은
    // 응답 객체의 key값에 errors가 있는지를 보고 판단하게 합니다.

    // ####################################### [ 주 의 ] #######################################
    // 한 주제에 대한 이해를 집중시키기 위해 '정상적인' 요청-응답 을 위한 코드만 있음을 알려드립니다.

    // Create
    @PostMapping()
    @ResponseStatus(CREATED)   // ResponseEntity(HttpStatus.OK) 를 대체
    public ResponseDTO createProduct(@RequestBody ProductRequestDTO request) {

        productService.createProduct(request.getName());

        return ResponseDTO.of(ProductResponseCode.PRODUCT_CREATE_OK);
    }

    // Read
    @GetMapping()
    public List<ProductResponseDTO> getProducts() {

        final List<Product> products = productService.getProducts();

        return products.stream()
                .map(it -> new ProductResponseDTO(it.getName()))
                .collect(Collectors.toList());
    }


    // Update
    @PutMapping("/{id}")
    public ResponseDTO updateProduct(@RequestBody ProductRequestDTO request, @PathVariable Long id) {

        productService.updateProduct(id, request.getName());

        return ResponseDTO.of(ProductResponseCode.PRODUCT_UPDATE_OK);
    }



    // Delete
    @DeleteMapping("/{id}")
    public ResponseDTO deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseDTO.of(ProductResponseCode.PRODUCT_DELETE_OK);
    }
}
