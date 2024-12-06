package asac06.hackathon.weather.service;


import asac06.hackathon.weather.dto.ProductDto;
import asac06.hackathon.weather.model.Product;
import asac06.hackathon.weather.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        List<Product> findProducts = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p : findProducts) {
            productDtos.add(ProductDto.from(p));
        }
        return productDtos;
    }
    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("USER NOT FOUND"));

    }

}
