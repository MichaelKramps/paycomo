package com.paycomo.tokenize;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class CardDataSerializer {

    public static String getEncodedCardNumber(String derPublicKey, String plainTextCardNumber) {
        byte[] decodedKeyMaterial = derPublicKey.getBytes();
        try {
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decodedKeyMaterial));

            Cipher oaepFromAlgo = Cipher.getInstance("RSA/None/OAEPWithSHA256AndMGF1Padding", "BC");
            oaepFromAlgo.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] cipherText = oaepFromAlgo.doFinal(plainTextCardNumber.getBytes());

            String encoded = Base64.getEncoder().encodeToString(cipherText);
            return encoded;
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
