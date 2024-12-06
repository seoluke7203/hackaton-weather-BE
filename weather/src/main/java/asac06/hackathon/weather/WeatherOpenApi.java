package asac06.hackathon.weather;

import asac06.hackathon.weather.repository.dto.WeatherItem;
import asac06.hackathon.weather.repository.dto.WeatherResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class WeatherOpenApi {
    static Integer temp;
    public static WeatherResponseDTO getWeathers() {
        StringBuilder urlStringBuilder = new StringBuilder("https://apihub.kma.go.kr/api/typ02/openApi/VilageFcstInfoService_2.0/getUltraSrtNcst");
        StringBuilder resultStringBuilder = new StringBuilder();

        String today = LocalDateTime.now().minusHours(1).format(DateTimeFormatter.ofPattern("yyyyMMddHH00"));

        String authKey = "JMkAYpdcRUuJAGKXXDVLuQ";
        String pageNo = "1";
        String numOfRows = "100";
        String dataType = "JSON";
        String baseDate = today.substring(0,8);
        String baseTime = today.substring(8,12);
        String nx = "57";
        String ny = "126";

        urlStringBuilder.append("?pageNo=" + pageNo);
        urlStringBuilder.append("&numOfRows=" + numOfRows);
        urlStringBuilder.append("&dataType=" + dataType);
        urlStringBuilder.append("&base_date=" + baseDate);
        urlStringBuilder.append("&base_time=" + baseTime);
        urlStringBuilder.append("&nx=" + nx);
        urlStringBuilder.append("&ny=" + ny);
        urlStringBuilder.append("&authKey=" + authKey);

        try {
            // 기상청 api 호출
            URL url = new URL(urlStringBuilder.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                resultStringBuilder.append(inputLine);
            }
            in.close();
            con.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }

        String result = resultStringBuilder.toString();
        WeatherResponseDTO weatherResponseDTO = getWeatherItem(result);

        return weatherResponseDTO;
    }


    public static WeatherResponseDTO getWeatherItem(String result) {
        ObjectMapper objectMapper = new ObjectMapper();

        JSONObject resultObj = new JSONObject(result);
        JSONObject response = resultObj.getJSONObject("response");
        JSONObject body = response.getJSONObject("body");
        JSONObject jsonItems = body.getJSONObject("items");
        JSONArray jsonItemList = jsonItems.getJSONArray("item");

        WeatherResponseDTO weatherResponseDTO = new WeatherResponseDTO();

        try {
            List<WeatherItem> weatherItems = Arrays.asList(objectMapper.readValue(jsonItemList.toString(), WeatherItem[].class));

            weatherItems.stream().forEach(item -> {
                if("T1H".equals(item.getCategory())){
                    String temperature = item.getObsrValue();
                    int roundTemp = Math.round(Float.valueOf(temperature));
                    weatherResponseDTO.setTemperature(roundTemp);

                    temp = roundTemp;
                }
                if("PTY".equals(item.getCategory())){
                    String ptyCode = item.getObsrValue();
                    weatherResponseDTO.setPtyCode(ptyCode);
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
        return weatherResponseDTO;
    }
}
