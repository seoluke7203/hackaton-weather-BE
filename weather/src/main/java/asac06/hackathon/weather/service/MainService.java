package asac06.hackathon.weather.service;

import asac06.hackathon.weather.dto.ProductDto;
import asac06.hackathon.weather.model.Product;
import asac06.hackathon.weather.repository.dto.ProductResponseDto;

import java.util.List;

public interface MainService {
    public List<ProductResponseDto> getRecommend(String code);
}
