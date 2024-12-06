package asac06.hackathon.weather.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Cart {

    @Id @GeneratedValue
    @Column(name = "cart_id")
    private Integer id;
    private Integer product_id;

    @Enumerated(EnumType.STRING)
    private Size size;
    private Integer count;
    private Integer price;

}
