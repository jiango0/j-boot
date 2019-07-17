package com.cmb;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Shion.W
 * @version V1.0, 2019/5/17 15:03
 */
public class QrcodeUtil {

    static Logger log = LoggerFactory.getLogger(QrcodeUtil.class);

    /**
     * BASE64的图片识别成二维码链接
     *
     * @param base64String
     * @return
     */
    public static String getTextFromBase64(String base64String) {
        try {
            if (base64String.startsWith("data:image/png;base64,")) {
                base64String = base64String.substring(base64String.indexOf(",") + 1);
            }
            log.debug("base64 -> {}", base64String);
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(base64String);
            MultiFormatReader formatReader = new MultiFormatReader();
            LuminanceSource luminanceSource = new BufferedImageLuminanceSource(ImageIO.read(new ByteArrayInputStream(bytes)));
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
            Result result = formatReader.decode(binaryBitmap);
            log.debug("result -> {}", result.getText());
            return result.getText();
        } catch (IOException | NotFoundException e) {
            log.error("base64 to test error", e);
        }

        return null;
    }
}
