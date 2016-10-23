package org.zhangyoubao.httpServer.response;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: rudy
 * @date: 2016/10/23
 * json数组响应
 */
public class JsonListResponse extends AbstractResponse {
    private int code;
    private List data;
    private String message = "";
    private int listSize = 0;

    private JsonListResponse(){
        code = 200;
        data = new LinkedList<>();
        message = "";
        listSize = 0;

        headers.add("Content-Type", "application/json;charset=utf-8");
    }

    public static JsonListResponse createResponse(){
        return new JsonListResponse();
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
        return JSON.toJSONString(this);
    }
}
