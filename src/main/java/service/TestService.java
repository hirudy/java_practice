package service;

import org.zhangyoubao.httpServer.Request;
import org.zhangyoubao.httpServer.ServiceBase;
import org.zhangyoubao.httpServer.response.AbstractResponse;
import org.zhangyoubao.httpServer.response.JsonListResponse;
import org.zhangyoubao.httpServer.response.JsonObjectResponse;
import org.zhangyoubao.httpServer.response.JsonpObjectResponse;
import org.zhangyoubao.httpServer.service.HelloService;

/**
 * @author: rudy
 * @date: 2016/10/23
 */
public class TestService extends HelloService {

    public AbstractResponse actionTest(Request request){
        JsonpObjectResponse response = JsonpObjectResponse.createResponse();
        response.requestSet(request);
        return response;
    }

    public AbstractResponse actionHello(Request request){
        return null;
    }
}
