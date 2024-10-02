package com.selenium.utillity;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reusable {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    public static Response getUsers() {
        return RestAssured.get(BASE_URL + "/users");
    }

    public static Response getTodos() {
        return RestAssured.get(BASE_URL + "/todos");
    }

    public static List<Map<String, Object>> filterFanCodeUsers(List<Map<String, Object>> users) {
        return users.stream()
                .filter(user -> {
                    Map<String, Object> address = (Map<String, Object>) user.get("address");
                    Map<String, Object> geo = (Map<String, Object>) address.get("geo");
                    double lat = Double.parseDouble((String) geo.get("lat"));
                    double lng = Double.parseDouble((String) geo.get("lng"));
                    return lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100;
                })
                .collect(Collectors.toList()); // Use Collectors.toList() instead of toList()
    }


}
