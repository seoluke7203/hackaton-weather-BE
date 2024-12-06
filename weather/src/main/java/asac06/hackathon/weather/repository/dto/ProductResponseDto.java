package asac06.hackathon.weather.repository.dto;

import asac06.hackathon.weather.model.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDto {

    private Integer id;
    private String name;
    private String category;
    private Integer price;
    //    private String link;
    private String img;
    private String recommendCode;

    public static ProductResponseDto from(Product product) {
        return new ProductResponseDto(product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getImg(), product.getRecommendCode());
    }
}
