package org.zhangyoubao.httpServer;

import com.alibaba.fastjson.JSON;
import javafx.util.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: rudy
 * @date: 2016/10/23
 * 服务管理器
 */
public class ServiceManager extends HashMap<String,Pair<String,String>> {
    private static ServiceManager instance = new ServiceManager();
    private static String configFilePath = "";

    public static ServiceManager getInstance(){
        return instance;
    }

    public synchronized void loadConfig(String configFilePath) throws IOException{
        FileInputStream in = null;
        try {
            File file = new File(configFilePath);
            int fileLength = (int)file.length();
            byte[] buffer = new byte[fileLength];

            in = new FileInputStream(file);
            int readLength = in.read(buffer,0,fileLength);
            if (readLength != fileLength){
                throw new Exception("file content length is not match");
            }
            Map map = JSON.parseObject(new String(buffer, Charset.forName("UTF-8")),HashMap.class);
            for(Object row : map.entrySet()) {
                Entry entry = (Entry) row;
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                String[] arr = value.split("::", 2);
                if (arr.length != 2) {
                    throw new Exception("service::action parse error");
                }
                this.put(key, new Pair<>(arr[0], arr[1]));
            }
            ServiceManager.configFilePath = configFilePath;
            System.out.println(String.format("file (%s) load success!", configFilePath));
        } catch (Exception e) {
            System.out.println(String.format("file (%s) load error, no server api map!", configFilePath));
        } finally{
            if(in!=null){
                in.close();
            }
        }
    }


}
