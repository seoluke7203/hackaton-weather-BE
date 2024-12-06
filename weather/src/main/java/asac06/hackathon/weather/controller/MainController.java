package asac06.hackathon.weather.controller;

import asac06.hackathon.weather.common.ApiResponse;
import asac06.hackathon.weather.dto.ProductDto;
import asac06.hackathon.weather.model.Product;
import asac06.hackathon.weather.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

//    @GetMapping("/api/main")
//    public ResponseEntity<ApiResponse<List<ProductDto>>> getWeather() {
//
//        List<ProductDto> resultList = mainService.getRecommend();
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ApiResponse<>(200, null, resultList));
//    }
}
//}
