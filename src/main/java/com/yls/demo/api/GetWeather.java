package com.yls.demo.api;

import com.yls.demo.Http;
import com.yls.demo.Json;
import com.yls.demo.PropertyConfig;
import com.yls.demo.pojo.Weather;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author yunglee on 2021/07/24
 * @package com.yls.demo.api
 */
@SwaggerDefinition(
        info = @Info(
                description = "This is a sample server",
                version = "1.0.0",
                title = "Swagger Sample Servlet",
                termsOfService = "http://swagger.io/terms/",
                contact = @Contact(name = "Sponge-Bob", email = "apiteam@swagger.io", url = "http://swagger.io"),
                license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")
        ),
        consumes = "application/json",
        produces = "application/json",
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        tags = {@Tag(name = "weather", description = "Operations about weather")}
)
@Api(value = "/weather")
@WebServlet("/api/weather")
public class GetWeather extends HttpServlet {
    private static final Logger log = LogManager.getLogger(GetWeather.class);
    private static final String CWB_URL = PropertyConfig.get("cwb.url") + PropertyConfig.get("cwb.resource.id");

    @ApiOperation(httpMethod = "GET", value = "Resource to get weather data", response = Weather.class, nickname = "getWeather")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success to get weather data", response = com.yls.demo.pojo.ApiResponse.class),
            @ApiResponse(code = 400, message = "Invalid input", response = com.yls.demo.pojo.ApiResponse.class)
    })
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jsonString;
        try {
            String result = Http.get(CWB_URL);
            Weather weather = Json.fromJson(result, Weather.class);
            jsonString = Json.prettyJson(weather);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            jsonString = Json.prettyJson(new com.yls.demo.pojo.ApiResponse<>(400, ex.getMessage()));
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println(jsonString);
//        out.flush();
        response.getOutputStream().write(jsonString.getBytes(StandardCharsets.UTF_8));
    }
}
