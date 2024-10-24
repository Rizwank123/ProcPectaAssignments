package com.procpecta.dev.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.procpecta.dev.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private static String API_URL = "https://fakestoreapi.com/";
    @Override
    public List<Product> GetProductByCategory(String cat) throws Exception {
    	 String url = API_URL + "products/category/" + cat;

         URL obj = new URL(url);
         HttpURLConnection con = (HttpURLConnection) obj.openConnection();
         con.setRequestMethod("GET");
         con.setRequestProperty("Accept", "application/json");

         int responseCode = con.getResponseCode();
         if (responseCode != HttpURLConnection.HTTP_OK) {
             throw new Exception("HTTP error code: " + responseCode);
         }

         // Reading the response
         BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
         String inputLine;
         StringBuilder response = new StringBuilder();
         while ((inputLine = in.readLine()) != null) {
             response.append(inputLine);
         }
         in.close();

         // Parse the JSON response
         ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.readValue(response.toString(), new TypeReference<List<Product>>() {});
     }
    

    @Override
    public Product CreateProduct(Product in) throws Exception {
    	 String url = API_URL + "products";
         ObjectMapper objectMapper = new ObjectMapper();  // Jackson for JSON serialization
         String jsonInputString = objectMapper.writeValueAsString(in);

         URL obj = new URL(url);
         HttpURLConnection con = (HttpURLConnection) obj.openConnection();
         con.setRequestMethod("POST");
         con.setRequestProperty("Content-Type", "application/json; utf-8");
       con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

         try (OutputStream os = con.getOutputStream()) {
             byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
           os.write(input, 0, input.length);
        }

         int responseCode = con.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("HTTP error code: " + responseCode);
        }
              
         // Parse the response
         return  objectMapper.readValue(con.getInputStream(), Product.class);
         
    }
    	
    	
    

}
