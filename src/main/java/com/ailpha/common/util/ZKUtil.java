package com.ailpha.common.util;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

public class ZKUtil {

	private static Logger logger = LoggerFactory.getLogger(ZKUtil.class);
	public static String CONNECT_STRING = "192.168.6.128:2181,192.168.6.129,192.168.6.130";
	public static int SESSION_TIMEOUT = 2000;
	public static String AUTH_INFO = "ysfu:fuys0822";
	public static ZooKeeper zk = null;

	public static void main(String[] args) throws Exception {
		zk = new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, new Watcher() {
			public void process(WatchedEvent event) {
				try {
					zk.exists("/fuys", true);
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		zk.addAuthInfo("digest", AUTH_INFO.getBytes());
		
		if(zk.exists("/fuys", true)!=null){
			logger.info("Watch node --> /fuys");
			List<String> children = zk.getChildren("/fuys", true);
			Iterator<String> iter = children.iterator();
			while(iter.hasNext()){
				logger.info("Watch children node --> " + iter.next());
			}
		}
		Thread.sleep(Integer.MAX_VALUE);
		
//		if(zk.exists("/fuys", false)!=null){
//			byte[] data = zk.getData("/fuys", false, null);
//			logger.info("Get data --> " + new String(data));
//			Stat setData = zk.setData("/fuys", "No death".getBytes(), -1);
//			logger.info("Set data --> " + setData);
//		}
//		if(zk.exists("/fuys/song", false)!=null){
//			logger.info("Delete /fuys/song");
//			zk.delete("/fuys/song", -1);
//		}
//		if(zk.exists("/fuys/song", false)==null){
//			for(int i=0;i<10;i++){
//				String create = zk.create("/fuys/song", "No Death".getBytes(), 
//						ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
//				logger.info("create EPHEMERAL_SEQUENTIAL node --> " + create);
//			}
//		}
//		if(zk.exists("/fuys/song", false)==null){
//			String create = zk.create("/fuys/song", "No Death".getBytes(), 
//					ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//			logger.info("create node --> " + create);		
//		}
//		if(zk.exists("/fuys/yun", false)==null){
//			String create = zk.create("/fuys/yun", "No Death".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//			logger.info("create node --> " + create);
//		}
//		 if(zk.exists("/", false)!=null){
//		 List<String> children = zk.getChildren("/", false);
//		 Iterator<String> iter = children.iterator();
//		 while(iter.hasNext()){
//		 logger.info("ChildNode --> " + iter.next());
//		 }
//		 }
		zk.close();
	}
}
