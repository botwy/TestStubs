package ru.botwy.TestStubs.util;

import ru.botwy.TestStubs.Models.dto.ProductDTO;

public interface JsonConverter {
    String convertToJson(ProductDTO productDTO);
    String convertToJson(ProductDTO[] productDTOs);
    ProductDTO fromJson(String json);
}
