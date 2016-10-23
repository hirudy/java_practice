package org.zhangyoubao.httpServer;

import com.sun.net.httpserver.Headers;
import org.zhangyoubao.httpServer.lib.StringUtil;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: rudy
 * @date: 2016/10/22
 * 请求对象
 */

public class Request {
    public enum Method{
        GET, POST
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime){
        this.startTime = startTime;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public InetSocketAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public InetSocketAddress getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(InetSocketAddress localAddress) {
        this.localAddress = localAddress;
    }

    public Map<String, String> getGetData() {
        return getData;
    }

    public void setGetData(Map<String, String> getData) {
        this.getData = getData;
    }

    public Map<String, String> getPostData() {
        return postData;
    }

    public void setPostData(Map<String, String> postData) {
        this.postData = postData;
    }

    public ServerConfig getConfig() {
        return config;
    }

    /**
     * 获取请求的md5值 get/post请求
     * @return
     */
    public String getRequestDataMD5(){
        StringBuilder builder = new StringBuilder();
//        builder.append("headers=").append(headers.entrySet().toString()).append(',');
        builder.append("url_path=").append(uri.getPath()).append(',');
        builder.append("getData=").append(getData.toString()).append(',');
        builder.append("postData=").append(postData.toString());
        return StringUtil.md5(builder.toString());
    }

    /**
     * 获取请求的post/get参数
     * @param key
     * @param defaultValue
     * @return
     */
    public String getRequestParam(String key, String ...defaultValue){
        if (postData.containsKey(key)){
            return postData.get(key);
        }else if (getData.containsKey(key)){
            return getData.get(key);
        }else{
            if (defaultValue != null && defaultValue.length > 0){
                return defaultValue[0];
            }else{
                return "";
            }
        }
    }

    /**
     * 获取请求中被params[]包裹的参数
     * @param key
     * @param defaultValue
     * @return
     */
    public String getRequestWrappedParam(String key, String ...defaultValue){
        StringBuilder builder = new StringBuilder();
        builder.append("params[").append(key).append(']');
        String tempDefault = "";
        if (defaultValue != null && defaultValue.length > 0){
            tempDefault = defaultValue[0];
        }
        return getRequestParam(builder.toString(),tempDefault);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        builder.append("startTime=").append(startTime).append(',');
        builder.append("headers=").append(headers.entrySet().toString()).append(',');
        builder.append("method=").append(method.toString()).append(',');
        builder.append("uri=").append(uri.toString()).append(',');
        builder.append("remoteAddress=").append(remoteAddress.toString()).append(',');
        builder.append("localAddress=").append(localAddress.toString()).append(',');
        builder.append("getData=").append(getData.toString()).append(',');
        builder.append("postData=").append(postData.toString());

        return builder.toString();
//        return JSON.toJSONString(this);
    }

    private int startTime = 0; // 请求开始时间
    private Headers headers;  // 头部信息
    private Method method;  // 请求类型
    private URI uri; // uri
    private InetSocketAddress remoteAddress; // 远端请求地址
    private InetSocketAddress localAddress; // 服务器地址
    private ServerConfig config = ServerConfig.getInstance(); // app.properties中的配置项

    private Map<String, String> getData = new TreeMap<>();  // get参数
    private Map<String, String> postData = new TreeMap<>(); // post参数

}
