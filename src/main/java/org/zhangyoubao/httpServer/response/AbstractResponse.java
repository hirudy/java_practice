package org.zhangyoubao.httpServer.response;

import com.sun.net.httpserver.Headers;
import org.zhangyoubao.httpServer.Request;

/**
 * @author: rudy
 * @date: 2016/10/22
 * 响应基类
 *
 * 不能用getter/setter方法,不然fastjson转换成字符串时候, 用了getter/setter的私有/保护属性也会被转换
 */
public abstract class AbstractResponse {
    protected Headers headers = new Headers();
    protected Integer httpCode = 200;
    protected Request request;
    /**
     * 获取响应头部信息对象
     * @return
     */
    public Headers headersGet() {
        return headers;
    }

    /**
     * 获取httpCode
     * @return
     */
    public int httpCodeGet(){
        return httpCode;
    }

    /**
     * 设置httpCode
     * @param code
     */
    public void httpCodeSet(int code){
        this.httpCode = code;
    }


    /**
     * 设置请求对象
     * @param request
     */
    public void requestSet(Request request){
        this.request= request;
    }

    /**
     * 返回请求对象
     * @return
     */
    public Request requestGet(){
        return this.request;
    }

    /**
     * 将响应体转换为响应body字符串
     * @return
     */
    public abstract String bodyToString();

}
