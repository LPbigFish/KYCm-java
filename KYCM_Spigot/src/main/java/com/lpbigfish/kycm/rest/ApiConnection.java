package com.lpbigfish.kycm.rest;

import com.lpbigfish.kycm.Main;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class ApiConnection {
    private static URL url;
    public ApiConnection(Main plugin) {
        try {
            //get api url from config
            url = new URL(Objects.requireNonNull(plugin.getConfig().getString("api-url")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static URL getUrl() {
        return url;
    }

    public static int getResponse(String playerName) {
        try {
            //Create a new URL with the player name
            URL player_endpoint = new URL(url.toString().replace("{player}", playerName));
            //Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) player_endpoint.openConnection();
            //Set the request method to GET
            connection.setRequestMethod("GET");
            //Connect to the URL
            connection.connect();
            //Get the response code
            int responseCode = connection.getResponseCode();
            //If the response code is 200, return 200, else return 404
            if (responseCode == 200)
                return 200;
            else
                return 404;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 404;
    }
}
