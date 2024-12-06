package asac06.hackathon.weather.repository.dto;

import lombok.Data;

import java.util.List;

@Data
public class WeatherItems {
    List<WeatherItem> weatherItems;
}
