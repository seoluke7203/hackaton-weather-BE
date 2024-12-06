package asac06.hackathon.weather.service.impl;

import asac06.hackathon.weather.model.Product;
import asac06.hackathon.weather.repository.ProductRepository;
import asac06.hackathon.weather.repository.dto.ProductResponseDto;
import asac06.hackathon.weather.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final ProductRepository productRepository;

    public List<ProductResponseDto> getRecommend(String code) {

        List<Product> productList = productRepository.findByRecommendCode(code);

        List<ProductResponseDto> products = productList.stream()
                .map(product -> ProductResponseDto.from(product))
                .collect(Collectors.toList());
        return products;
    }
}
