package org.zhangyoubao.httpServer.handler;

import org.zhangyoubao.httpServer.Request;
import org.zhangyoubao.httpServer.response.AbstractResponse;
import org.zhangyoubao.httpServer.response.PlainResponse;

/**
 * @author: rudy
 * @date: 2016/10/22
 *
 * 默认处理handler
 */
public class DefaultHandler extends AbstractHandler {
    @Override
    public AbstractResponse execute(Request request) throws Exception {
        PlainResponse response = PlainResponse.createResponse();
        response.httpCodeSet(404);
        return response;
    }
}
