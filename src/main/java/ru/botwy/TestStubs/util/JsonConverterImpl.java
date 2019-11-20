package ru.botwy.TestStubs.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ru.botwy.TestStubs.Models.dto.ProductDTO;

public class JsonConverterImpl implements JsonConverter {

    private final Gson gson;

    public JsonConverterImpl() {
        gson = new GsonBuilder().create();
    }

    public String convertToJson(ProductDTO productDTO) {
        return gson.toJson(productDTO);
    }

    public String convertToJson(ProductDTO[] productDTOs) {
        return gson.toJson(productDTOs);
    }

    public ProductDTO fromJson(String json) {
        return gson.fromJson(json, ProductDTO.class);
    }
}
