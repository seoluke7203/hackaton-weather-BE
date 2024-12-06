package asac06.hackathon.weather.controller;


import asac06.hackathon.weather.dto.ProductDto;
import asac06.hackathon.weather.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/main")
    public ResponseEntity<List<ProductDto>> AllProducts() {
        List<ProductDto> productDtos = productService.findAll();
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(productDtos);
    }

//    @GetMapping("/main")
//    public ResponseEntity<List<ProductDto>> AllProducts() {
//        List<ProductDto> productDtos = productService.findAll();
//        return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(productDtos);
//    }
}
