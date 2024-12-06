package asac06.hackathon.weather.repository.dto;

import lombok.Data;

@Data
public class WeatherItem {
    private String baseDate;
    private String baseTime;
    private String category;
    private String nx;
    private String ny;
    private String obsrValue;
}
