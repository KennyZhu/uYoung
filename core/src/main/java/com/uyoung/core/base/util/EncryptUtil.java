package com.uyoung.core.base.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

public final class EncryptUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptUtil.class);
    private static final String ALGORITHM = "DESede"; //定义加密算法,可用 DES,DESede,Blowfish
    private static final byte[] ECODE_STR =
            {(byte) 0xef, 0x2b, (byte) 0xcc, (byte) 0xdc, (byte) 0x9b, 0x3b, (byte) 0xf7, 0x2a, 0x68, (byte) 0xad,
                    (byte) 0xeb, 0x72, (byte) 0xe3, 0x78, 0x2f, 0x5e, 0x7, 0x77, (byte) 0xd5, (byte) 0xc1, 0x7d, 0x40, 0x66,
                    (byte) 0xb8};

    //keybyte为加密密钥，长度为24字节
    //src为被加密的数据缓冲区（源）
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, ALGORITHM);
            //加密
            Cipher c1 = Cipher.getInstance(ALGORITHM);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);//在单一方面的加密或解密
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    //keybyte为加密密钥，长度为24字节
    //src为加密后的缓冲区
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, ALGORITHM);
            //解密
            Cipher c1 = Cipher.getInstance(ALGORITHM + "/ECB/PKCS5Padding");
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    /*
     *生成密钥 encodeKeyA.length=24
     */
    public static byte[] genCroptyKey(byte[] encodeKeyA, String randomStrB) {
        if (encodeKeyA == null) {
            return null;
        }
        byte[] A = encodeKeyA;
        byte[] B = new byte[24];
        byte[] C = randomStrB.getBytes();
        int alen = A.length;
        int clen = C.length;
        if (alen != 24 || (clen < 8 || clen > 20))
            return null;
        int demension = alen - clen;
        System.arraycopy(C, 0, B, 0, C.length);

        int piont = 1;
        while (demension > 0) {
            if (demension > clen) {
                System.arraycopy(C, 0, B, clen * piont + 0, clen);
                piont++;

            } else {
                System.arraycopy(C, 0, B, clen * piont + 0, demension);
            }
            demension = demension - clen;

        }
        byte[] result = new byte[24];
        for (int i = 0; i < alen; i++) { //0 ^  1 |  2 &

            switch ((i + 1) % 3) {
                case 0:
                    result[i] = (byte) (A[i] ^ B[i]);
                    break;
                case 1:
                    result[i] = (byte) (A[i] & B[i]);
                    break;
                case 2:
                    result[i] = (byte) (A[i] | B[i]);
                    break;
            }

        }

        return result;
    }

    public static String getBASE64(byte[] b) {
        String s = null;
        if (b != null) {
            s = new sun.misc.BASE64Encoder().encode(b);
        }
        return s;
    }

    public static byte[] getFromBASE64(String s) {
        byte[] b = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                return b;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    /**
     * 传输加密参数，组合
     *
     * @param oraStr
     * @return
     */
    public static String restructParam(String oraStr) {

        try {
            byte[] keys = EncryptUtil.ECODE_STR;
            if (StringUtils.isNotBlank(oraStr)) {

                String stampStr = EncryptUtil.RndString(10, null);
                byte[] encodeKeys = EncryptUtil.genCroptyKey(keys, stampStr);
                byte[] result = EncryptUtil.encryptMode(encodeKeys, oraStr.getBytes());
                String base64Str = EncryptUtil.getBASE64(result);
                try {
                    String data = URLEncoder.encode(base64Str, "utf-8");
                    String lastStr = data + "&stamp=" + URLEncoder.encode(stampStr, "utf-8");
                    return lastStr;
                } catch (UnsupportedEncodingException e) {
                    LOGGER.error("UnsupportedEncodingException:", e);
                    return null;
                }
            }
        } catch (Exception e) {
            LOGGER.error("error in restructParam", e);
        }
        return null;

    }

    /**
     * 生成随机字符串
     */
    public static String RndString(int Length, int[] Seed) {
        String strSep = ",";
        // char[] chrSep = strSep.ToCharArray();

        //这里定义字符集
        String strChar = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"
                + ",A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,W,X,Y,Z";

        String[] aryChar = strChar.split(strSep, strChar.length());

        String strRandom = "";
        Random Rnd;
        if (Seed != null && Seed.length > 0) {
            Rnd = new Random(Seed[0]);
        } else {
            Rnd = new Random();
        }

        //生成随机字符串
        for (int i = 0; i < Length; i++) {
            strRandom += aryChar[Rnd.nextInt(aryChar.length)];
        }

        return strRandom;
    }

    public static void test() throws UnsupportedEncodingException {
        //apiVer=1.1&data=&stamp=4658813633344
        final byte[] ecodeStr =
                {(byte) 0xef, 0x2b, (byte) 0xcc, (byte) 0xdc, (byte) 0x9b, 0x3b, (byte) 0xf7, 0x2a, 0x68, (byte) 0xad,
                        (byte) 0xeb, 0x72, (byte) 0xe3, 0x78, 0x2f, 0x5e, 0x7, 0x77, (byte) 0xd5, (byte) 0xc1, 0x7d, 0x40,
                        0x66, (byte) 0xb8};
        String stamp = "4658813633344";
        byte[] miyao = EncryptUtil.genCroptyKey(ecodeStr, stamp);
        String szSrc = "userName=bjtestsf%40163.com&sessionId=85A9E20FB6E92CBF2A293688F6EA5817";
        System.out.println("加密前的字符串:" + szSrc);
        byte[] encoded = encryptMode(miyao, szSrc.getBytes());
        System.out.println("加密后的字符串:" + new String(encoded));
        String baseStr = EncryptUtil.getBASE64(encoded);
        System.out.println("base64加密后的字符串:" + baseStr);
        System.out.println("---------hhh-----------------");

        byte[] base = EncryptUtil
                .getFromBASE64("xAPRtRAkGMYl9ibjVtzOxvXnf1i3FtIzZucEKu0M27BhCLyKJlYoE40DUFcc4LRWpes94f2w7xnaeUaRF8vwJstXHSrlIjJ8");

        byte[] decodeBytes = EncryptUtil.decryptMode(miyao, base);

        String decodeStr = new String(decodeBytes, "utf-8");
        System.out.println("base64解密后的字符串:" + decodeStr);
    }
}
