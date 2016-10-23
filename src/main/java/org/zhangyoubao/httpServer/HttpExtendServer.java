package org.zhangyoubao.httpServer;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import javafx.util.Pair;
import org.apache.log4j.PropertyConfigurator;
import org.zhangyoubao.httpServer.lib.StringUtil;
import org.zhangyoubao.httpServer.handler.DefaultHandler;
import org.zhangyoubao.httpServer.handler.PingHandler;
import org.zhangyoubao.httpServer.handler.ServiceHandler;

import java.awt.geom.IllegalPathStateException;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.*;

/**
 * @author: rudy
 * @date: 2016/10/22
 *
 * 基于java内嵌的httpserver实现的http服务器装饰器
 */
public class HttpExtendServer extends HttpServer {
    private HttpServer server; // 装饰的具体服务对象

    private final ServerConfig config = ServerConfig.getInstance(); // 配置文件对象

    private String confDir = ""; // 配置文件存放目录

    @Override
    public void bind(InetSocketAddress inetSocketAddress, int i) throws IOException {
        this.server.bind(inetSocketAddress, i);
    }

    @Override
    public void start() {
        this.server.start();
        System.out.println("http server start ,listen on " + config.getPort() + " ...");
    }

    @Override
    public void setExecutor(Executor executor) {
        this.server.setExecutor(executor);
    }

    @Override
    public Executor getExecutor() {
        return this.server.getExecutor();
    }

    @Override
    public void stop(int i) {
        this.server.stop(i);
    }

    @Override
    public HttpContext createContext(String s, HttpHandler httpHandler) {
        return this.server.createContext(s, httpHandler);
    }

    @Override
    public HttpContext createContext(String s) {
        return this.server.createContext(s);
    }

    @Override
    public void removeContext(String s) throws IllegalArgumentException {
        this.server.removeContext(s);
    }

    @Override
    public void removeContext(HttpContext httpContext) {
        this.server.removeContext(httpContext);
    }

    @Override
    public InetSocketAddress getAddress() {
        return this.server.getAddress();
    }

    /**
     * 创建服务
     * @return
     * @throws Exception
     */
    public final void initService() throws Exception {
        // 创建服务
        HttpServer rawServer = HttpServer.create();
        this.server = rawServer;

        // 初始化默认配置
        this.initConf();

        // 设置端口绑定
        this.bind(
                new InetSocketAddress(this.config.getPort()),
                this.config.getTcpMaxAcceptQueueNum()
        );

        // 设定 workers执行器
        this.setExecutor(new ThreadPoolExecutor(
                this.config.getMinWorkersNum(),
                this.config.getMaxWorkersNum(),
                this.config.getIdleWorkersTime(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(
                        this.config.getWorkerMaxQueueNum()
                )
        ));

        // 添加默认handler
        this.createContext("/", new DefaultHandler());
        this.createContext("/ping",new PingHandler());
        this.createContext("/service/rest",new ServiceHandler());

        // 执行可选初始化操作
        ServiceManager.getInstance().put("hello.world", new Pair<>("org.zhangyoubao.httpServer.service.HelloService","World"));
        ServiceManager.getInstance().loadConfig(this.getConfDir() + File.separator + "apiConfig.json");

        PropertyConfigurator.configureAndWatch(this.getConfDir() + File.separator + "log4j.properties");

        this.initOptional();
    }

    /**
     * 初始化配置
     */
    public void initConf() throws Exception {
        String confDir = System.getProperty("conf");
        if (StringUtil.emptyOrNull(confDir)){
            String appDir = System.getProperty("user.dir");
            if (StringUtil.emptyOrNull(appDir)){
                throw new IllegalPathStateException("no config dir");
            }
            confDir = appDir + File.separator + "conf";
        }
        this.confDir = confDir;
        config.loadConfig(confDir + File.separator + "app.properties");
    }

    public String getConfDir(){
        return confDir;
    }

    /**
     * 可选初始化操作,子类可重载
     */
    public void initOptional() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        HttpExtendServer server = new HttpExtendServer();
        server.initService();
        server.start();
    }
}
