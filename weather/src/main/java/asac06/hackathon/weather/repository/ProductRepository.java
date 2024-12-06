package asac06.hackathon.weather.repository;


import asac06.hackathon.weather.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    List<Product> findAll();

    @Query("select p from Product p where p.recommendCode like %:code")
    List<Product> findByRecommendCode(@Param("code") String code);
}