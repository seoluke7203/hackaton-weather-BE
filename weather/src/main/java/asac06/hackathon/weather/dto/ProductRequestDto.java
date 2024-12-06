package asac06.hackathon.weather.dto;


import asac06.hackathon.weather.model.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDto {

    private Integer id;
    private Size size;
    private Integer price;

}
