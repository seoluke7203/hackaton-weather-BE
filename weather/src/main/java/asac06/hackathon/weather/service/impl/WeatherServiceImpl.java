package asac06.hackathon.weather.service.impl;

import asac06.hackathon.weather.WeatherOpenApi;
import asac06.hackathon.weather.repository.dto.WeatherResponseDTO;
import asac06.hackathon.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public WeatherResponseDTO getWeatherData() {
        WeatherResponseDTO weatherResponseDTO = WeatherOpenApi.getWeathers();
        return weatherResponseDTO;
    }
}


