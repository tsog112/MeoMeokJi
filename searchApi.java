package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class searchApi {
    private String query;

    public searchApi() {
        // Default constructor
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<RestaurantInfo> searchRestaurants() {
        String clientId = "gxCwTW1USgmQU7efK_Dd"; // Replace with your own Naver API client ID
        String clientSecret = "faEGSpaPfI"; // Replace with your own Naver API client secret
        
        try {
            query = URLEncoder.encode(query, "UTF-8");
            String category = "FD6"; // "음식점" 카테고리 코드 (FD6)
            String apiURL = "https://openapi.naver.com/v1/search/local.json?query=" + query + "&display=10&category=음식점"; // 로컬 검색 API
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            int responseCode = con.getResponseCode();
            if (responseCode == 200) { // Normal response
                StringBuilder res = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    res.append(inputLine);
                }
                br.close();

                // JSON 응답을 JsonObject로 파싱
                String jsonResult = res.toString();
                JsonObject jsonObject = JsonParser.parseString(jsonResult).getAsJsonObject();
                JsonArray items = jsonObject.getAsJsonArray("items");

                List<RestaurantInfo> restaurantList = new ArrayList<>();

                // items 배열을 반복하면서 각 항목을 RestaurantInfo 객체로 변환하여 리스트에 추가
                for (int i = 0; i < items.size(); i++) {
                    JsonObject item = items.get(i).getAsJsonObject();
                    RestaurantInfo restaurantInfo = new RestaurantInfo();
                    restaurantInfo.setTitle(item.get("title").getAsString());
                    restaurantInfo.setLink(item.get("link").getAsString());
                    restaurantInfo.setCategory(item.get("category").getAsString());
                    restaurantInfo.setDescription(item.get("description").getAsString());
                    restaurantInfo.setTelephone(item.get("telephone").getAsString());
                    restaurantInfo.setAddress(item.get("address").getAsString());
                    restaurantInfo.setRoadAddress(item.get("roadAddress").getAsString());
                    restaurantInfo.setMapx(item.get("mapx").getAsInt());
                    restaurantInfo.setMapy(item.get("mapy").getAsInt());
                    restaurantList.add(restaurantInfo);
                }
                
                return restaurantList;
            } else {
                return new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}