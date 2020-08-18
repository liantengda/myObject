package com.lian.myObject.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;

/**
 * 枚举工具类
 *
 * 枚举可真是个神奇的物种
 *
 * @author Ted
 * @date 2020/8/17 14:24
 */
@Slf4j
public enum MyAES128 {


    AES_CBC_PKCS5PADDING_ENCRYPT("AES/CBC/PKCS5Padding") {
        @Override
        public String doFinal(String content, String encryptKey) {
            if (encryptKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (encryptKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            try {

                byte[] raw = encryptKey.getBytes("utf-8");
                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance(getCipherMode());//"算法/模式/补码方式"
                IvParameterSpec iv = new IvParameterSpec(encryptKey.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
                byte[] encrypted = cipher.doFinal(content.getBytes());
                return new String(new Base64().encode(encrypted));//此处使用BASE64做转码功能，同时能起到2次加密的作用。
            }catch (Exception e){
                log.info("出错了");
                return null;
            }
        }
    },

    AES_CBC_PKCS5PADDING_DECRYPT("AES/CBC/PKCS5Padding") {
        @Override
        public String doFinal(String content, String encryptKey) {
            try {
                // 判断Key是否正确
                if (encryptKey == null) {
                    System.out.print("Key为空null");
                    return null;
                }
                // 判断Key是否为16位
                if (encryptKey.length() != 16) {
                    System.out.print("Key长度不是16位");
                    return null;
                }
                byte[] raw = encryptKey.getBytes("utf-8");
                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance(getCipherMode());
                IvParameterSpec iv = new IvParameterSpec(encryptKey.getBytes());
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
                byte[] encrypted1 = new Base64().decode(content);//先用base64解密
                try {
                    byte[] original = cipher.doFinal(encrypted1);
                    String originalString = new String(original);
                    return originalString;
                } catch (Exception e) {
                    System.out.println(e.toString());
                    return null;
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
                return null;
            }
        }
    },

    AES_DEFAULT_ENCRYPT("AES") {
        @Override
        public String doFinal(String content, String pwd) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者

                kgen.init(128, new SecureRandom(pwd.getBytes()));// 利用用户密码作为随机数初始化出
                // 128位的key生产者
                //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行

                SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥

                byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥，如果此密钥不支持编码，则返回
                // null。

                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥

                Cipher cipher = Cipher.getInstance(getCipherMode());// 创建密码器

                byte[] byteContent = content.getBytes("utf-8");

                cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化为加密模式的密码器

                byte[] result = cipher.doFinal(byteContent);// 加密

                return DatatypeConverter.printHexBinary(result);

            } catch (Exception e) {
                return null;
            }
        }
    },

    AES_DEFAULT_DECRYPT("AES") {
        @Override
        public String doFinal(String content, String pwd) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
                kgen.init(128, new SecureRandom(pwd.getBytes()));
                SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
                byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥
                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
                Cipher cipher = Cipher.getInstance(getCipherMode());// 创建密码器
                cipher.init(Cipher.DECRYPT_MODE, key);// 初始化为解密模式的密码器
                byte[] result = cipher.doFinal(DatatypeConverter.parseHexBinary(content));
                return new String(result); // 明文

            } catch (Exception e) {

            }
            return null;
        }
    },

    NO_PADDING_ENCRYPT("AES/ECB/NoPadding") {
        @Override
        public String doFinal(String str, String password) {

            try {
                Cipher cipher = Cipher.getInstance(getCipherMode());
                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(MyAES128.to16BitBytes(password), "AES"));
                byte[] bytes = cipher.doFinal(MyAES128.to16BitBytes(str));
                return DatatypeConverter.printHexBinary(bytes);
            } catch (Exception e) {

                log.error("NO_PADDING_ENCRYPT error {} use pwd {}", str, password);
                return null;
            }
        }
    },



    AES_CBC_PKCS7PADDING_ENCRYPT("AES/CBC/PKCS7Padding","1954682168745975") {
        @Override
        public String doFinal(String content, String encryptKey) {
            try {
                Cipher cipher = Cipher.getInstance(getCipherMode());
                SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(defaultCharset), "AES");
                AlgorithmParameterSpec paramSpec = new IvParameterSpec(getIV().getBytes());
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
                byte[] utf8s = cipher.doFinal(content.getBytes(defaultCharset));
                return Base64.encodeBase64String(utf8s);
            } catch (Exception e) {
                log.error("NO_PADDING_ENCRYPT error {} use pwd {}", content, encryptKey);
                return "出错";
            }
        }
    },

    NO_PADDING_DECRYPT("AES/ECB/NoPadding") {
        @Override
        public String doFinal(String hexStr, String pwd) {

            try {
                Cipher cipher = Cipher.getInstance(getCipherMode());
                cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(MyAES128.to16BitBytes(pwd), "AES"));
                byte[] result = cipher.doFinal(DatatypeConverter.parseHexBinary(hexStr));
                return new String(result);

            } catch (Exception e) {
                log.error("NO_PADDING_DECRYPT error {} use pwd {}", hexStr, pwd);
                return null;
            }
        }
    },
    AES_CBC_PKCS7PADDING_DECRYPT("AES/CBC/PKCS7Padding","1954682168745975") {
        @Override
        public String doFinal(String content, String encryptKey) {
            try {
                Cipher cipher = Cipher.getInstance(getCipherMode());
                SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(defaultCharset), "AES");
                AlgorithmParameterSpec paramSpec = new IvParameterSpec(getIV().getBytes());
                cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
                byte[] bytes = Base64.decodeBase64(content);
                return new String(cipher.doFinal(bytes), defaultCharset);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    };

    private static final String defaultCharset = "utf8";

    private  String cipherMode;
    private  String IV;

    MyAES128(String cipherMode){
        this.cipherMode = cipherMode;
    }

    MyAES128(String cipherMode,String IV){
        this.cipherMode = cipherMode;
        this.IV = IV;
    }

    public String getCipherMode(){
        return cipherMode;
    }

    public String getIV(){
        return IV;
    }


    public abstract String doFinal(String content, String encryptKey);


    /**
     * 填充16位
     * @param str
     * @return
     */
    private static byte[] to16BitBytes(String str) {
        int len= (str.length()/16+str.length()%16==0?0:1)*16;
        byte[] bs = new byte[len];
        System.arraycopy(str.getBytes(), 0, bs, 0, str.length());
        return bs;
    }


    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args){
        String originPwd = "12345678";
        String encryptKey = "impooriwantmoney";

        //无填充模式
        String noPaddingStr = MyAES128.NO_PADDING_ENCRYPT.doFinal(originPwd, encryptKey);
        log.info("NO_PADDING加密后：{}",noPaddingStr);
        log.info("NO_PADDING解密后：{}",MyAES128.NO_PADDING_DECRYPT.doFinal(noPaddingStr, encryptKey));

        //默认模式
        String defaultStr = MyAES128.AES_DEFAULT_ENCRYPT.doFinal(originPwd, encryptKey);
        log.info("DEFAULT_AES加密后: {}",defaultStr);
        log.info("DEFAULT_AES解密后: {}",MyAES128.AES_DEFAULT_DECRYPT.doFinal(defaultStr,encryptKey));

        //PAES/CBC/PKCS7Padding 模式
        String pkcs7paddingStr = MyAES128.AES_CBC_PKCS7PADDING_ENCRYPT.doFinal(originPwd, encryptKey);
        log.info("AES/CBC/PKCS7Padding加密后: {}",pkcs7paddingStr);
        log.info("AES/CBC/PKCS7Padding解密后: {}",MyAES128.AES_CBC_PKCS7PADDING_DECRYPT.doFinal(pkcs7paddingStr,encryptKey));

        //PAES/CBC/PKCS5Padding 模式
        String pkcs5paddingStr = MyAES128.AES_CBC_PKCS5PADDING_ENCRYPT.doFinal(originPwd, encryptKey);
        log.info("AES/CBC/PKCS5Padding加密后: {}",pkcs5paddingStr);
        log.info("AES/CBC/PKCS5Padding解密后：{}",MyAES128.AES_CBC_PKCS5PADDING_DECRYPT.doFinal(pkcs5paddingStr, encryptKey));
    }
}
