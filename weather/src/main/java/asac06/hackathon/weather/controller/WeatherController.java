package asac06.hackathon.weather.controller;

import asac06.hackathon.weather.common.ApiResponse;
import asac06.hackathon.weather.repository.dto.WeatherResponseDTO;
import asac06.hackathon.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/api/weather")
    public ResponseEntity<ApiResponse<WeatherResponseDTO>> getWeather() {

        WeatherResponseDTO result = weatherService.getWeatherData();

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(200, null, result));
    }

}
