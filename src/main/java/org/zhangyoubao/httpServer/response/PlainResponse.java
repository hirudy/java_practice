package org.zhangyoubao.httpServer.response;

/**
 * @author: rudy
 * @date: 2016/10/23
 * 文本响应
 */
public class PlainResponse extends AbstractResponse {
    private String text;

    private PlainResponse(){
        text = "";
        headers.add("Content-Type", "text/plain;charset=utf-8");
    }

    public static PlainResponse createResponse(){
        return new PlainResponse();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String bodyToString() {
        return text;
    }
}
