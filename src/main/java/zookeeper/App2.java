package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * @author: rudy
 * @date: 2016/10/27
 */
public class App2 {

    private static ZooKeeper zooKeeper;

    private static class AppWatcher implements Watcher {

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent);
            try {
                if (watchedEvent.getPath() != null){
                    zooKeeper.getChildren(watchedEvent.getPath(),true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        zooKeeper = new ZooKeeper("127.0.0.1:2181",30000, new AppWatcher());
        Stat data =  zooKeeper.exists("/rudy/group",false);
        if (data == null){
            zooKeeper.create("/rudy/group","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        zooKeeper.create("/rudy/group/child","".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
        zooKeeper.getChildren("/rudy/group",true);
        System.out.println(data);
        while (true){
            Thread.sleep(1000);
        }
    }
}
