package com.yls.app.api;

import com.yls.app.Http;
import com.yls.app.Json;
import com.yls.app.PropertyConfig;
import com.yls.app.pojo.Weather;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yunglee on 2021/07/24
 * @package com.yls.demo.api
 */
@WebServlet("/weather")
public class GetWeather extends HttpServlet {
    private static final String CWB_URL = PropertyConfig.get("cwb.url") + PropertyConfig.get("cwb.resource.id");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = Http.get(CWB_URL);
        Weather weather = Json.fromJson(result, Weather.class);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(Json.prettyJson(weather));
        out.flush();
    }
}
