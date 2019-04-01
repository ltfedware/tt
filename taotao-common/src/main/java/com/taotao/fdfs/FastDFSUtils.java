package com.taotao.fdfs;

import org.csource.fastdfs.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * PACKAGE_NAME com.taotao.fdfs
 * Created by ltfedware on 2017/11/11.
 */
public class FastDFSUtils {
    //需要连接的tracker服务器连接信息
    // public static final String conf_filename = "client.conf";
    //需要上传的文件
    //public static final String local_filename= "2.jpg";
    public static String[] upload(String conf_file,byte[] buffer,String suffix) {
        //String path = this.getClass().getResource("/").getPath();
        //System.out.println(path);
        try {
            ClientGlobal.init(conf_file);
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            String[] strings = storageClient.upload_file(buffer, suffix, null);
            // System.out.println(fileIds.length);
            // System.out.println("组名：" + fileIds[0]);
            // System.out.println("路径: " + fileIds[1]);
            return strings;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
