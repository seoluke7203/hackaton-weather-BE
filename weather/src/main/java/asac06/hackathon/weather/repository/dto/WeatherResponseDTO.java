package asac06.hackathon.weather.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherResponseDTO {
    int temperature;
    String ptyCode;
}