package org.zhangyoubao.httpServer;

import org.zhangyoubao.httpServer.lib.StringUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author: rudy
 * @date: 2016/10/22
 *
 * 服务配置文件类
 */

public class ServerConfig{
    private static ServerConfig instance;

    private Properties properties = new Properties(); // 具体配置项
    private String configPath = ""; // 配置路径

    public static ServerConfig getInstance(){
        if (instance == null){
            synchronized (ServerConfig.class){
                if (instance == null){
                    instance = new ServerConfig();
                }
            }
        }
        return instance;
    }

    public synchronized int loadConfig(String configFilePath) throws Exception {
        InputStream in = null;
        try {
            in = new FileInputStream(configFilePath);
            properties.load(in);
            System.out.println("load config dir: " + configFilePath);
            configPath = configFilePath;
        } catch (Exception e) {
            System.out.println(String.format("conf file (%s) not found, use default setting!", configFilePath));
        } finally{
            if(in!=null){
                in.close();
            }
        }

        // 设置必要的默认值
        properties.setProperty("port",this.getConfItem("port", "8888"));
        properties.setProperty("min_workers_num",this.getConfItem("min_workers_num", "5"));
        properties.setProperty("max_workers_num",this.getConfItem("max_workers_num", "128"));
        properties.setProperty("idle_workers_time",this.getConfItem("idle_workers_time", "120"));
        properties.setProperty("tcp_max_accept_queue_num",this.getConfItem("tcp_max_accept_queue_num", "128"));
        properties.setProperty("worker_max_queue_num",this.getConfItem("worker_max_queue_num", "2048"));
        return 1;
    }

    public Properties getProp(){
        return properties;
    }

    public String getConfigPath(){
        return configPath;
    }

    /**
     * 根据key获取配置项
     * @param key
     * @return
     */
    public String getConfItem(String key){
        return getConfItem(key, "");
    }

    public String getConfItem(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

    /**
     * 服务监听的端口
     * @return
     */
    public int getPort(){
        return StringUtil.convertInt(getConfItem("port"), 0);
    }

    /**
     * 服务线程池最小线程数
     * @return
     */
    public int getMinWorkersNum(){
        return StringUtil.convertInt(getConfItem("min_workers_num"), 0);
    }

    /**
     * 服务线程池最大线程数
     * @return
     */
    public int getMaxWorkersNum(){
        return StringUtil.convertInt(getConfItem("max_workers_num"), 0);
    }

    /**
     * 服务线程池线程最大空闲时间,单位秒
     * @return
     */
    public int getIdleWorkersTime(){
        return StringUtil.convertInt(getConfItem("idle_workers_time"), 0);
    }

    /**
     * tcp 接收队列最大值
     * @return
     */
    public int getTcpMaxAcceptQueueNum(){
        return StringUtil.convertInt(getConfItem("tcp_max_accept_queue_num"), 0);
    }

    /**
     * 线程任务队列最大值
     * @return
     */
    public int getWorkerMaxQueueNum(){
        return StringUtil.convertInt(getConfItem("worker_max_queue_num"), 0);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getName()).append('[');
        for (Map.Entry<Object, Object> entry : properties.entrySet()){
            builder.append(entry.getKey()).append('=').append(entry.getValue()).append(',');
        }
        builder.append(']');
        return builder.toString();
    }
}
