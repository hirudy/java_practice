package org.zhangyoubao.httpServer;

import com.sun.net.httpserver.Headers;
import org.zhangyoubao.httpServer.response.AbstractResponse;

import java.util.List;
import java.util.Map;

/**
 * @author: rudy
 * @date: 2016/10/22
 *
 * 响应代理
 */
public class ResponseProxy {
    private AbstractResponse response;

    public void setResponse(AbstractResponse response){
        this.response = response;
    }

    public void sendResponseHeaders(Headers responseHeaders){
        if (response == null){
            return;
        }
        // 默认头部
        responseHeaders.add("Server","TJHttpServer");
        Headers temp = response.headersGet();
        for (Map.Entry<String,List<String>> entry: temp.entrySet()){
            if (!entry.getValue().isEmpty()){
                for(String value : entry.getValue()){
                    responseHeaders.add(entry.getKey(),value);
                }
            }
        }
    }

    public String getBody(){
        if (response == null){
            return "";
        }
        return this.response.bodyToString();
    }

    public int getHttpCode(){
        if (response == null){
            return 500;
        }
        return response.httpCodeGet();
    }
}
