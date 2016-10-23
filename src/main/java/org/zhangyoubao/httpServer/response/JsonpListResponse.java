package org.zhangyoubao.httpServer.response;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: rudy
 * @date: 2016/10/23
 *
 * jsonp数组响应, json数组装饰器
 */
public class JsonpListResponse extends AbstractResponse {
    private int code;
    private List data;
    private String message = "";
    private int listSize = 0;

    private JsonpListResponse(){
        code = 200;
        data = new LinkedList<>();
        message = "";
        listSize = 0;

        headers.add("Content-Type", "text/javascript;charset=utf-8");
    }

    public static JsonpListResponse createResponse(){
        return new JsonpListResponse();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    @Override
    public String bodyToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("try{")
                .append(request.getRequestParam("callback","callback_fun"))
                .append('(')
                .append(JSON.toJSONString(this))
                .append(");}catch(e){}");
        return builder.toString();
    }
}
