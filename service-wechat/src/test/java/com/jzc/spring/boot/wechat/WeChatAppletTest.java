package com.jzc.spring.boot.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.springframework.util.StringUtils;
import weixin.popular.api.SnsAPI;
import weixin.popular.bean.sns.Jscode2sessionResult;
import weixin.popular.bean.wxa.WxaDUserInfo;
import weixin.popular.util.WxaUtil;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;

@Slf4j
public class WeChatAppletTest {

    @Test
    public void decryptUser() {

        String sessionKey = "d3UCd14nSm2dsHUq353tjw==";
        String encryptedData = "XYzRFux+cLjol1X74JXWCUL6wns0C9+0YhITwFlfON3tOLsQMnIuMGcJuGXonbM42AqLAB7yNJ7W7tp9c2aEfl0Rn/QFVCv3wZ1ov+2Cl1nP15FEmpM6DQ19I6Y5JljM5TUZcIxfbwbFQlfOdcGbLw1R8tBDt1iqwS/XZsPshtpGGS3Mm6uJeBNgNRMocFN9aLlAh5IlAj1i3LYMOzwyzwoAcechFS14zKOcxeK7G5sfTB5NkPZ+src/7b7/1Q0ua2wBSIhzDtDrM2dd9+YiSf1PKPnIXcVS9X799nEFfhDIs839aBEvdU1mqdzFBcgHkU1MCB8sQvx6pxZTvR6YsMJH92txIYtTD0v+5HXtUAJ0eiTpXlwmenHaKlODAWEf+Xq1x1qXK264Q4sJhiaJCrUXrjxVFOjljrMSLwHC1Jk0zLjeVGodMgGZVte8CMXZecaUBewHUOPWQDaCJBasUFrajksCgpUz6mp83APwJf/cCufDuS8gJP7tPc/RkftNacRmYpf/0gtoKlUR2ha0hA==";
        String iv = "QDaBAn/pF+xBqiVZPF0GmA==";

        String sessionKey2 = "7jK3phmRBj42nDyU6k62bA==";
        String encryptedData2 = "e1TRV/Whv8glHR1AqEpNIuiS0ETOYDk1u2qQkQKIhu+BnV68Qq2YjzXY0AY4iGGcpn4AB0xqvlElGGAL9ewdZlyXiJNPNWy8TGLRmgZPNEFTggCKh7ByP7yBZtdYzSZInWekBwydw1up2sTOVtg24wFaa5UbDHgkFR77PL27wSyIGqsm1HrM65Vc+nxXv4SFHCFL/P+lCNYkJZg0LUTyXA==";
        String iv2 = "ZIYcHnkeWBZ3l2494gtPTA==";

        String decrypt = WxaUtil.decrypt(sessionKey2, encryptedData2, iv2);

//        System.out.println(decrypt);
//        log.info("decrypt {} ", JSON.toJSONString(decrypt));

//        JSONObject object = decryptionUserInfo(encryptedData2, sessionKey2, iv2);
//        log.info("object {}", JSON.toJSONString(object));

        WxaDUserInfo wxaDUserInfo = WxaUtil.decryptUserInfo(sessionKey2, encryptedData2, iv2);
        log.info("wxaDUserInfo {} ", JSON.toJSONString(wxaDUserInfo));
    }

    @Test
    public void decryptUser2() {
        String code = "043qAEgp09N5ln1A6thp0RQjgp0qAEg9";
        String encryptedData = "";
        String iv = "";

        Jscode2sessionResult jscode2sessionResult = SnsAPI.jscode2session("wx8e42d53ad532956b", "3a79e47baa5094255e452b1521032e14", code);
        if (!jscode2sessionResult.isSuccess()) {
            log.error(jscode2sessionResult.getErrmsg() + "," + jscode2sessionResult.getErrcode());
        }
        if (StringUtils.isEmpty(jscode2sessionResult.getSession_key())) {
            log.error("获取微信用户信息失败");
        }
        log.info("jscode {} ", JSON.toJSONString(jscode2sessionResult));
        if (StringUtils.isEmpty(jscode2sessionResult.getUnionid())) {
            if (StringUtils.isEmpty(encryptedData) || StringUtils.isEmpty(iv)) {
                log.error("encryptedData , iv is null");
                return;
            }
            log.debug("wxaDUserInfo decrypt userInfo {} {}", jscode2sessionResult.getSession_key());
            WxaDUserInfo wxaDUserInfo = WxaUtil.decryptUserInfo(jscode2sessionResult.getSession_key(), encryptedData, iv);
            if (wxaDUserInfo == null || StringUtils.isEmpty(wxaDUserInfo.getUnionId())) {
                log.error("unionId is null");
                return;
            }
            jscode2sessionResult.setUnionid(wxaDUserInfo.getUnionId());
        }
    }

    public static JSONObject decryptionUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
