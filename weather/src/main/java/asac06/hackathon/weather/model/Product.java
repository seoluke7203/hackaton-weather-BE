package asac06.hackathon.weather.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id @GeneratedValue
    @Column(name = "product_id")
    private Integer id;
    private String name;
    private String category;
    private Integer price;
//    private String link;
    private String img;
    private String recommendCode;
//    @OneToMany(mappedBy = "product")
//    private List<ProductOrder> productOrders;
}
