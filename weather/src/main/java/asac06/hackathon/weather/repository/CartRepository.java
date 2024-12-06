package asac06.hackathon.weather.repository;

import asac06.hackathon.weather.model.Cart;
import asac06.hackathon.weather.model.Product;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByProductId(Integer id);


}
