package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

/**
 * @author: rudy
 * @date: 2016/10/27
 */
public class App {

    private static ZooKeeper zooKeeper;

    private static class AppWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent);
            try {
                if (watchedEvent.getPath() != null){
                    byte[] a  = zooKeeper.getData(watchedEvent.getPath(),true,null);
                    System.out.println(a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        zooKeeper = new ZooKeeper("127.0.0.1:2181",30000,new AppWatcher());

//        String create =  zooKeeper.create("/rudy/aa3","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE ,CreateMode.EPHEMERAL_SEQUENTIAL);
//        System.out.println(create);
        zooKeeper.create("/rudy/lock-","".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
        while (true){
            Thread.sleep(1000);
        }

    }
}
