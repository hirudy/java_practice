package org.zhangyoubao.httpServer;

import org.zhangyoubao.httpServer.response.AbstractResponse;

/**
 * @author: rudy
 * @date: 2016/10/23
 */
public class ServiceBase {

    public boolean beforeAction(Request request){
        return true;
    }

    public AbstractResponse afterAction(Request request, AbstractResponse response){
        return null;
    }
}
