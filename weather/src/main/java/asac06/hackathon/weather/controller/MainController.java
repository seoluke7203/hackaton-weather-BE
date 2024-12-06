package asac06.hackathon.weather.controller;

import asac06.hackathon.weather.common.ApiResponse;
import asac06.hackathon.weather.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/api/main")
    public ResponseEntity<ApiResponse<List<Product>>> getWeather() {

        List<Prod> resultList = mainService.getRecommend();


        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(200, null, resultList));
    }
}
