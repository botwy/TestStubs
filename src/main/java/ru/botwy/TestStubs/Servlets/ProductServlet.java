package ru.botwy.TestStubs.Servlets;

import ru.botwy.TestStubs.DAO.api.ProductDAO;
import ru.botwy.TestStubs.DAO.impl.ProductDAOImpl;
import ru.botwy.TestStubs.DaoFabric;
import ru.botwy.TestStubs.Models.dto.ProductDTO;
import ru.botwy.TestStubs.Models.entity.Product;
import ru.botwy.TestStubs.Services.ProductService;
import ru.botwy.TestStubs.util.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new ProductService().getLastProduct();
        ProductDTO productDTO = null;
        if (product != null) {
            productDTO = new ProductDTO();
            productDTO.setCode(product.getCode());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
        }
        JsonConverter converter = new JsonConverter();
        String json = converter.convertToJson(productDTO);

        resp.setContentType("application/json;charset=UTF-8");
        resp.setStatus(200);
        resp.getWriter().write(json);
    }
}
