package org.zhangyoubao.httpServer.handler;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.log4j.Logger;
import org.zhangyoubao.httpServer.lib.StringUtil;
import org.zhangyoubao.httpServer.Request;
import org.zhangyoubao.httpServer.response.AbstractResponse;
import org.zhangyoubao.httpServer.ResponseProxy;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * @author: rudy
 * @date: 2016/10/22
 * handler模板
 */
public abstract class AbstractHandler implements HttpHandler {
    public int getSecondTimestamp(){
        return (int)(System.currentTimeMillis()/1000);
    }
    public static Logger logger = Logger.getLogger("access");

    @Override
    public final void handle(HttpExchange httpExchange) throws IOException {
        try{
            long start_time = System.currentTimeMillis();
            Request request = new Request();
            request.setStartTime(getSecondTimestamp());
            request.setHeaders(httpExchange.getRequestHeaders());
            request.setUri(httpExchange.getRequestURI());
            request.setLocalAddress(httpExchange.getLocalAddress());
            request.setRemoteAddress(httpExchange.getRemoteAddress());

            // 响应头部消息句柄
            Headers responseHeaders =  httpExchange.getResponseHeaders();

            // 解析get参数
            List<NameValuePair> getList = URLEncodedUtils.parse(request.getUri(),"UTF-8");
            Map<String, String> getData = new TreeMap<>();
            for(NameValuePair pair: getList){
                getData.put(pair.getName(), pair.getValue());
            }
            request.setGetData(getData);



            // 只接收get, post请求
            String method = httpExchange.getRequestMethod().toLowerCase();
            switch (method){
                case "get": request.setMethod(Request.Method.GET);break;
                case "post": request.setMethod(Request.Method.POST);break;
                default: {
                    httpExchange.sendResponseHeaders(510, 0);
                    return;
                }
            }

            // 如果是post请求,读取post请求参数
            int contentLength = 0;
            if (httpExchange.getRequestHeaders().containsKey("Content-length")){
                contentLength = StringUtil.convertInt(httpExchange.getRequestHeaders().getFirst("Content-length"),0);
            }
            if (request.getMethod() == Request.Method.POST &&  contentLength > 0){
                InputStream in = httpExchange.getRequestBody();
                byte[] buffer = new byte[contentLength];
                int readLength = in.read(buffer,0,contentLength);
                if (readLength != contentLength){
                    httpExchange.sendResponseHeaders(411, 0);
                    return;
                }

                List<NameValuePair> list = URLEncodedUtils.parse(
                        new String(buffer,0,contentLength, Charset.forName("UTF-8")),
                        Charset.forName("UTF-8")
                );
                Map<String, String> postData = new TreeMap<>();
                for(NameValuePair pair: list){
                    postData.put(pair.getName(), pair.getValue());
                }
                request.setPostData(postData);
            }

            // 执行具体请求
            AbstractResponse response;
            logger.debug(request);
            try{
                response = execute(request);
                if (response == null){
                    throw new Exception("response is null:" + request);
                }
            }catch (Exception e){
                response = null;
                e.printStackTrace();
            }

            // 建立请求请求代理
            ResponseProxy proxy = new ResponseProxy();
            proxy.setResponse(response);
            String body = proxy.getBody();

            // 发送响应头部信息
            proxy.sendResponseHeaders(responseHeaders);
            responseHeaders.add("Server-Take-Time",String.valueOf(System.currentTimeMillis() - start_time));
            httpExchange.sendResponseHeaders(proxy.getHttpCode(), body.length());

            // 发送响应body
            OutputStream os = httpExchange.getResponseBody();
            os.write(body.getBytes());
            os.close();
        } catch (IOException e) {
            throw e;
        } catch (Exception e){
            e.printStackTrace();
            httpExchange.sendResponseHeaders(500, 0);
        }finally {
            httpExchange.close();
        }
    }

    public abstract AbstractResponse execute(Request request) throws Exception;
}
