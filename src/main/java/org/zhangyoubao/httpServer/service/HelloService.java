package org.zhangyoubao.httpServer.service;

import org.zhangyoubao.httpServer.Request;
import org.zhangyoubao.httpServer.ServiceBase;
import org.zhangyoubao.httpServer.response.AbstractResponse;
import org.zhangyoubao.httpServer.response.PlainResponse;

/**
 * @author: rudy
 * @date: 2016/10/23
 */
public class HelloService extends ServiceBase {
    public AbstractResponse actionWorld(Request request){
        PlainResponse response = PlainResponse.createResponse();
        response.setText("TJHttpServer");
        return response;
    }
}
