package ProvingGround;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import sun.net.httpserver.HttpServerImpl;
import util.DateUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.Executors;

/**
 * @author: rudy
 * @date: 2016/10/21
 *  java 内嵌http服务
 */
public class TestHttpServer {

    private static class HelloHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            int start_time = DateUtil.getSecondTimestamp();
            Headers requestHeaders =  httpExchange.getRequestHeaders();
            Headers responseHeaders =  httpExchange.getResponseHeaders();
            responseHeaders.set("Server","java");
            responseHeaders.set("Content-Type","application/json");

            Response response = new Response();
            response.setCode(200);
            response.setData(new ArrayList());
            response.setMessage("hello rudy");
            response.setTakeTime(DateUtil.getSecondTimestamp() - start_time);
            String responseString = JSON.toJSONString(response);
            httpExchange.sendResponseHeaders(200, responseString.length());

            OutputStream os = httpExchange.getResponseBody();
            os.write(responseString.getBytes());
            os.close();
            int end_time= DateUtil.getSecondTimestamp();
            System.out.println(Thread.currentThread().getName() + ":" + (end_time-start_time));
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8999),125);
        server.createContext("/",new HelloHandler());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("server started");
    }
}
