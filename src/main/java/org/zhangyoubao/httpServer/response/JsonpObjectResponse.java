package org.zhangyoubao.httpServer.response;

import com.alibaba.fastjson.JSON;

/**
 * @author: rudy
 * @date: 2016/10/23
 *
 * jsonp对象响应, json对象装饰器
 */
public class JsonpObjectResponse extends AbstractResponse {
    private int code;
    private Object data;
    private String message = "";

    private JsonpObjectResponse(){
        code = 200;
        data = new Object();
        message = "";
        headers.add("Content-Type", "text/javascript;charset=utf-8");
    }

    public static JsonpObjectResponse createResponse(){
        return new JsonpObjectResponse();
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
        StringBuilder builder = new StringBuilder();
        builder.append("try{")
                .append(request.getRequestParam("callback","callback_fun"))
                .append('(')
                .append(JSON.toJSONString(this))
                .append(");}catch(e){}");
        return builder.toString();
    }
}
