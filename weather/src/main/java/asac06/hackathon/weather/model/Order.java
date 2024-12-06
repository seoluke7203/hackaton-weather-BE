package asac06.hackathon.weather.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "product_order_id")
    private String productOrderId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private Boolean paid;

    @OneToMany(mappedBy = "order")
    private List<ProductOrder> productOrders;

}
