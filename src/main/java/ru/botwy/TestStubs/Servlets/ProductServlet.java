package ru.botwy.TestStubs.Servlets;

import ru.botwy.TestStubs.Models.dto.ProductDTO;
import ru.botwy.TestStubs.Models.entity.Product;
import ru.botwy.TestStubs.Services.ProductService;
import ru.botwy.TestStubs.Storage;
import ru.botwy.TestStubs.config.AppConfig;
import ru.botwy.TestStubs.config.Environment;
import ru.botwy.TestStubs.util.JsonConverter;
import ru.botwy.TestStubs.util.RequestReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Scanner;

public class ProductServlet extends HttpServlet {

    private final Environment currentEnvironment = AppConfig.shared.environment;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product[] products = new ProductService().getAllProducts();

        if (products == null) { return; }

        ProductDTO[] productDTOs = new ProductDTO[products.length];
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) { return; }

            System.out.println(product.getName());

            ProductDTO productDTO = new ProductDTO();
            productDTO.setCode(product.getCode());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTOs[i] = productDTO;
        }

        JsonConverter converter = currentEnvironment.getJsonConverter();
        String json = converter.convertToJson(productDTOs);

        resp.setContentType("application/json;charset=UTF-8");
        resp.setStatus(200);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonConverter converter = currentEnvironment.getJsonConverter();
        RequestReader reader = RequestReader.shared;
        String body = reader.getBody(req);
        ProductDTO productDTO = converter.fromJson(body);
        Product product = null;
        if (productDTO != null) {
            product = new Product(productDTO.getCode(), productDTO.getName(), productDTO.getPrice());
        }
        if (product != null) {
            Storage.shared.appendProduct(product);
        }
    }
}
