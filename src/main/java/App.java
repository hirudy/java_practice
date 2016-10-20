import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.*;

/**
 * @author: rudy
 * @date: 2016/10/09
 *
 * function description
 */
public class App {
    public static Logger logger = null;
    public static Properties appConf = new Properties();

    public static void init() throws IOException {
        // 获取配置路径
        String confDir = System.getProperty("user.dir","/usr/local") + File.separator + "conf";
        System.setProperty("app.conf_dir",confDir);

        // 初始化日志
        PropertyConfigurator.configure(confDir + File.separator + "log4j.properties");
        logger = Logger.getRootLogger();
        logger.debug("conf dir: " + System.getProperty("app.conf_dir"));

        // 初始化应用配置
        InputStream in = new FileInputStream(confDir + File.separator +"app.properties");
        appConf.load(in);
    }

    public static void main(String[] args) throws Exception {
        App.init();
        List<Thread> pool = new ArrayList<>();

//        FourThread.run();

        StringBuilder sb = new StringBuilder("012345678901234");
        sb.replace(1, 5, "ABCD");
        System.out.println("sb : " + sb);

        logger.info("main thread exit!");
    }
}
