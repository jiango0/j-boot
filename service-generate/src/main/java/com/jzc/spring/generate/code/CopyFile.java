package com.jzc.spring.generate.code;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {

    private static String target_path = "D:\\javaresources\\j-boot\\service-generate\\src\\main\\java\\com\\jzc\\spring\\generate\\temp\\";

    private static String target_package = "com.jzc.spring.generate.temp.";

    public static List<File> getAllFile(String directoryPath) {
        List<File> list = new ArrayList<>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }

        File[] files = baseFile.listFiles();

        for(File file : files) {
            if(!file.isDirectory()) {
                System.out.println(file.getAbsolutePath());
                list.add(file);
            }
        }

        return list;
    }

    public static void copyFile(List<File> list) {
        if(CollectionUtils.isEmpty(list)) {
            return;
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            for(File file : list) {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(new File(target_path + file.getName()));
                //创建搬运工具
                byte datas[] = new byte[1024*8];
                //创建长度
                int len = 0;
                //循环读取数据
                while((len = fis.read(datas))!=-1){
                    fos.write(datas,0,len);
                }

                fis.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null) {
                    fis.close();
                }
                if(fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getInterfacePath() {
        File path = new File(target_path);
        File[] files = path.listFiles();
        if(files != null && files.length != 0) {
            for(File file : files) {
                String fileName = file.getAbsolutePath();
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.lastIndexOf(".java"));

                System.out.println(target_package + fileName);

            }
        }

    }

}
