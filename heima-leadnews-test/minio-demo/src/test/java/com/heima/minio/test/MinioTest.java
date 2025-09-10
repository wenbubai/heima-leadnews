package com.heima.minio.test;


import com.heima.file.service.FileStorageService;
import com.heima.minio.MinIOApplication;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest(classes = MinIOApplication.class)
@RunWith(SpringRunner.class)
public class MinioTest {

    @Autowired
    private FileStorageService fileStorageService;

    @Test
    public void testUpdateImgFile() throws FileNotFoundException {
/*        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\tmp\\plugins\\css\\index.css");


            String filePath = fileStorageService.uploadImgFile("", "ak47.jpg", fileInputStream);
            System.out.println(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

/*        FileInputStream fileInputStream = new FileInputStream("D:\\list.html");
        String path = fileStorageService.uploadHtmlFile("", "list.html", fileInputStream);
        System.out.println(path);*/
     try {
         FileInputStream fileInputStream = new FileInputStream("D:\\tmp\\plugins\\js\\index.js");

         MinioClient minioClient= MinioClient.builder().credentials("minio","minio123").endpoint("http://192.168.200.130:9000").build();

         PutObjectArgs putObjectArgs=PutObjectArgs.builder()
                 .bucket("leadnews")
                 .object("plugins/js/index.js")
                 .stream(fileInputStream,fileInputStream.available(),-1)
                 .contentType("text/javascript")
                 .build();

         minioClient.putObject(putObjectArgs);

        } catch (Exception e) {
            e.printStackTrace();
     }


    }
}