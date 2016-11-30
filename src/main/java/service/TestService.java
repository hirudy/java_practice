package service;

import org.zhangyoubao.httpServer.HttpExtendServer;


/**
 * @author: rudy
 * @date: 2016/10/23
 */
public class TestService extends HttpExtendServer {

    public static void main(String[] args) throws Exception {
        TestService service = new TestService();
        service.initService();
        service.start();
    }
}
