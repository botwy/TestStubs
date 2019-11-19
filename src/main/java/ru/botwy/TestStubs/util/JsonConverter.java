package ru.botwy.TestStubs.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ru.botwy.TestStubs.Models.dto.ProductDTO;

public class JsonConverter {

    private final Gson gson;

    public JsonConverter() {
        gson = new GsonBuilder().create();
    }

    public String convertToJson(ProductDTO productDTO) {
        return gson.toJson(productDTO);
    }
}
