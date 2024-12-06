package asac06.hackathon.weather;


import asac06.hackathon.weather.model.Cart;
import asac06.hackathon.weather.model.Product;
import asac06.hackathon.weather.model.Size;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.productInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;


        public void productInit() {

            String name = "상품";
            String category;
            Integer price = 10000;
            String link = "link";
            String img = "img";

            for(int i = 1; i <= 10; i++) {
                name = name + i;
                price = price + 2000;
                if(i % 2 == 0) category = "top";
                else category = "bottom";

                Product product = createProduct(name, category, price, link, img);
//                Cart cart = initCart(product, Size.S, 1, product.getPrice());
//                em.persist(cart);
                em.persist(product);

//                Product product = createProduct(name, category, price, link, img);
//                em.persist(product);
//
//                Cart cart = initCart(product, Size.S, 1, product.getPrice());
//                em.persist(cart);
                name = "상품";
            }

        }

        public static Product createProduct(String name, String category, Integer price, String link, String img) {
            Product product = new Product();
            product.setName(name);
            product.setCategory(category);
            product.setPrice(price);
            product.setLink(link);
            product.setImg(img);

            return product;
        }

//        public Cart initCart(Product entity, Size size, Integer count, Integer price) {
//            return new Cart(1, entity, size, count, price);
//        }
    }
}
