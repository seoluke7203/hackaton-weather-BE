package asac06.hackathon.weather.dto;


import asac06.hackathon.weather.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {

    private Integer id;
    private String name;
    private Integer price;
    private String img;

    public static ProductDto from(Product entity) {
        return new ProductDto(entity.getId(), entity.getName(), entity.getPrice(), entity.getImg());
    }
}
