package ru.botwy.TestStubs.util;

import ru.botwy.TestStubs.Models.dto.ProductDTO;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class RequestReader {
    public static RequestReader shared = new RequestReader();

    private RequestReader() {

    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            throw ex;
        }  finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        return stringBuilder.toString();
    }

    public String getBody(HttpServletRequest request) throws IOException {
        InputStream inputStream = request.getInputStream();

        return readFromInputStream(inputStream);
    }

    public String getContent(String path) throws IOException {
        String json = "";
        try {
            InputStream fis = new FileInputStream(path);
            json = readFromInputStream(fis);
        } catch (IOException error) {
            System.out.println(error);
        }

        return json;
    }
}
