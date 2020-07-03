package com.jzc.spring.boot.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Slf4j
public class FirmWareDownload {

    private String url = "http://oss-test.kiscloud.net/file/rder/v3/20200701/RDER_FirmWare.zip";

    public InputStream downloadNet(String url) {
        // 下载网络文件
        try {
            URL fileurl = new URL(url);
            URLConnection conn    = fileurl.openConnection();
            return conn.getInputStream();
        } catch (IOException e) {
            log.error("downloadNet error", e);
            return null;
        }
    }

    @Test
    public void getFirmWare() {
        InputStream inputStream = downloadNet(url);

        try (ZipInputStream zis = new ZipInputStream(inputStream)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // 固件文件名
                String entryFileName = entry.getName();
                // 固件内容
                byte[] entryBytes = IOUtils.toByteArray(zis);

                log.info("firmware Name {}, firmware length {}", entryFileName, entryBytes.length);

            }
        } catch (Exception e) {
            log.error("下载失败", e);
        }

    }

}
