package asac06.hackathon;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitNaverProduct {
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

//        @RequiredArgsConstructor
//        public enum Genre {
//            MUSICAL(ProductGenre.MUSICAL,"/src/assets/images/posters/jesuschristPoster.jpeg", "/src/assets/images/postersDetail/jesusMainPic.jpg"),
//            CONCERT(ProductGenre.CONCERT,"/src/assets/images/posters/stillJypPoster.gif", "/src/assets/images/postersDetail/stillJypDetail.jpg"),
//            THEATER(ProductGenre.THEATER,"/src/assets/images/posters/aladinPoster.png", "/src/assets/images/postersDetail/performace1.jpg");
//
//            private final ProductGenre genre;
//            private final String productSrc;
//            private final String productDetail;
//        }

        public void productInit() {
            // naver api 호출



        }

//        private static Product createProduct() {
//            Product product = new Product();
//            return product;
//        }
    }
}
