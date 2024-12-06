package asac06.hackathon.weather.dto;


import asac06.hackathon.weather.model.Cart;
import asac06.hackathon.weather.model.Product;
import asac06.hackathon.weather.model.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartDto {

    private Integer Id;
    private String name;
    private String img;
    private Integer price;
    private Size size;

    public static CartDto from(Cart entity) {
        Product findProduct = entity.getProduct();
        return new CartDto(
            findProduct.getId(),
            findProduct.getName(),
            findProduct.getImg(),
            findProduct.getPrice(),
            entity.getSize()
        );
    }
}
