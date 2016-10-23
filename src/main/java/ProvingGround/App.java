package ProvingGround;

import org.zhangyoubao.httpServer.HttpExtendServer;


/**
 * @author: rudy
 * @date: 2016/10/22
 */
public class App extends HttpExtendServer {
    public void initOptional() throws Exception{
//        DataSourceFactory.init(getConfDir());
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.initService();
        app.start();
    }
}
