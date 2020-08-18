package com.lian.myObject.slideWindow;

import com.lian.myObject.common.utils.MyAES128;

/**
 * @author Ted
 * @version 1.0
 * @date 2020/8/18 21:37
 */
public class MyWork {

    public static void main(String[] args) {
        String myContent = "我想要成为傻傻的工具人，我很享受这种感觉，任何人都不要阻止我";
        String myKey = "imissyouiamhappy";
        String encryptContent = MyAES128.AES_DEFAULT_ENCRYPT.doFinal(myContent, myKey);
        String decryptContent = MyAES128.AES_DEFAULT_DECRYPT.doFinal(encryptContent, myKey);
        System.out.println("加密后的content-->"+encryptContent);
        System.out.println("解密后的content-->"+decryptContent);
    }
}
