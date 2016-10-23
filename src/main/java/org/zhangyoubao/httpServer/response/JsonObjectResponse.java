package org.zhangyoubao.httpServer.response;

import com.alibaba.fastjson.JSON;

/**
 * @author: rudy
 * @date: 2016/10/23
 * json对象响应
 *
 */
public class JsonObjectResponse extends AbstractResponse {
    private int code;
    private Object data;
    private String message = "";

    private JsonObjectResponse(){
        code = 200;
        data = new Object();
        message = "";
        headers.add("Content-Type", "application/json;charset=utf-8");
    }

    public static JsonObjectResponse createResponse(){
        return new JsonObjectResponse();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String bodyToString() {
        return JSON.toJSONString(this);
    }
}
