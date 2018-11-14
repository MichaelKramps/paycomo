package com.paycomo.tokenize;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class CardDataSerializer {
    private final String derPublicKey;
    private final String plainTextCardNumber;

    public CardDataSerializer(String derPublicKey, String plainTextCardNumber){
        this.derPublicKey = derPublicKey;
        this.plainTextCardNumber = plainTextCardNumber;
    }

    public String getEncodedCardNumber() {
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
