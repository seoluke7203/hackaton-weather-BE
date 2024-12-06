package asac06.hackathon.weather;

import asac06.hackathon.weather.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitNaverProduct {
    private final InitNaverProductService initNaverProductService;

    @PostConstruct
    public void init() {
        initNaverProductService.productInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitNaverProductService{

        private final EntityManager em;

        public void productInit() {
            // naver api 호출
            String result = naverShopSearch();

            // 네이버 데이터 파싱
            // product 적재
            getNaverProduct(result);
        }

        public String naverShopSearch() {
            String clientId = "algs6rvsCIALuPoEffAL"; //애플리케이션 클라이언트 아이디
            String clientSecret = "Vz1txXsO9D"; //애플리케이션 클라이언트 시크릿

            StringBuilder resultStringBuilder = new StringBuilder();

            StringBuilder sb = new StringBuilder("https://openapi.naver.com/v1/search/shop.json");

            String query = "롱코트";

            try {
                query = URLEncoder.encode(query, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("검색어 인코딩 실패",e);
            }

            String display = "10";
            String start = "1";

            sb.append("?query=" + query);
//        sb.append("&display=" + display);
//        sb.append("&start=" + start);


            try{
                URL url = new URL(sb.toString());
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    resultStringBuilder.append(inputLine);
                }

                in.close();
                con.disconnect();

            }catch (IOException e){
                throw new RuntimeException(e);
            }

            String result = resultStringBuilder.toString();

            return result;
        }

        public void getNaverProduct(String result) {
            JSONObject resultObj = new JSONObject(result);

            JSONArray jsonItems = resultObj.getJSONArray("items");

            for(int i=0; i<jsonItems.toList().size(); i++){
                JSONObject jsonObject = jsonItems.getJSONObject(i);
                String title = jsonObject.getString("title");
                String image = jsonObject.getString("image");
                int lprice = jsonObject.getInt("lprice");

                Product product = createProduct(title, image, lprice);

                em.persist(product);
            }
        }

        private static Product createProduct(String title, String image, int lprice) {
            Product product = new Product();

            product.setName(title);
            product.setImg(image);
            product.setPrice(lprice);

            return product;
        }
    }
}