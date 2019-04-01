package com.taotao;

import org.csource.fastdfs.*;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * PACKAGE_NAME com.taotao
 * Created by ltfedware on 2017/11/11.
 */
@Ignore
public class uploadTest {
    //需要连接的tracker服务器连接信息
    public static final String conf_filename = "client.conf";

    //需要上传的文件
    public static final String local_filename= "1.jpg";

    @Test
    public void testFastdfs() {
        String path = this.getClass().getResource("/").getPath();
        System.out.println(path);
        try {
            ClientGlobal.init(path+conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);

            String fileIds[] = storageClient.upload_file(path+local_filename, null, null);

            System.out.println(fileIds.length);
            System.out.println("组名：" + fileIds[0]);
            System.out.println("路径: " + fileIds[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
