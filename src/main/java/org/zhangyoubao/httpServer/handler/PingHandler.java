package org.zhangyoubao.httpServer.handler;

import org.zhangyoubao.httpServer.Request;
import org.zhangyoubao.httpServer.response.AbstractResponse;
import org.zhangyoubao.httpServer.response.PlainResponse;

/**
 * @author: rudy
 * @date: 2016/10/22
 *
 * ping handler
 */
public class PingHandler extends AbstractHandler {
    @Override
    public AbstractResponse execute(Request request) throws Exception {
        PlainResponse response =  PlainResponse.createResponse();
        response.setText("ok");
        return response;
    }
}
