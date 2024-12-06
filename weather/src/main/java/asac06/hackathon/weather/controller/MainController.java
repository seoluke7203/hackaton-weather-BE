package asac06.hackathon.weather.controller;

import asac06.hackathon.weather.common.ApiResponse;
import asac06.hackathon.weather.repository.dto.ProductResponseDto;
import asac06.hackathon.weather.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/api/main/{code}")
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> getWeather(@PathVariable("code") String code) {
        List<ProductResponseDto> resultList = mainService.getRecommend(code);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(200, null, resultList));
    }
}
