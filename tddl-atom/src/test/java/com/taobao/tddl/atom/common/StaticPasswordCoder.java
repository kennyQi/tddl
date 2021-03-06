package com.taobao.tddl.atom.common;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.taobao.tddl.atom.securety.TPasswordCoder;
import com.taobao.tddl.common.utils.extension.Activate;

@Activate(order = 1)
public class StaticPasswordCoder implements TPasswordCoder {

    public String encode(String encKey, String secret) throws NoSuchAlgorithmException, NoSuchPaddingException,
                                                      InvalidKeyException, IllegalBlockSizeException,
                                                      BadPaddingException {
        if (secret.equals("tddl")) {
            return "4485f91c9426e4d8";
        } else if (secret.equals("diamond")) {
            return "-6e3251280f47bc7d";
        } else {
            return "tddl";
        }
    }

    public String encode(String secret) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
                                       BadPaddingException, IllegalBlockSizeException {
        return encode(secret, null);
    }

    public String decode(String encKey, String secret) throws NoSuchPaddingException, NoSuchAlgorithmException,
                                                      InvalidKeyException, BadPaddingException,
                                                      IllegalBlockSizeException {
        if (secret.equals("4485f91c9426e4d8")) {
            return "tddl";
        } else if (secret.equals("-6e3251280f47bc7d")) {
            return "diamond";
        } else {
            return "tddl";
        }
    }

    public char[] decode(String secret) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
                                       BadPaddingException, IllegalBlockSizeException {
        return decode(secret, null).toCharArray();
    }
}
