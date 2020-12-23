package com.jzc.spring.generate;

import com.jzc.spring.generate.code.CopyFile;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;

public class GenerateCodeMain {

    private static String path = "D:\\javaresources\\ty-mall-product\\ty-product-business\\src\\main\\jzc\\com\\toonyoo\\product\\business\\controller";


    public static void main(String[] args) {
        //获取指定目录下的全部文件
        List<File> allFile = CopyFile.getAllFile(path);
        if(!CollectionUtils.isEmpty(allFile)) {
            //copy指定目录下的全部文件
            CopyFile.copyFile(allFile);

            CopyFile.getInterfacePath();

        }

    }

}
