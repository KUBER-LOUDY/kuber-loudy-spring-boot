package com.kuberloudy.api.global.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.*;
import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.*;

import java.util.Base64;


@RequiredArgsConstructor
@Configuration
public class rsaUtil {

    @Value("${keyPair.path}")
    private String path;
    @Value("${keyPair.algorithm}")
    private String algorithm;
    @Value("${keyPair.keysize}")
    private int keysize;

    private void createKey() throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
        generator.initialize(keysize);
        KeyPair pair = generator.generateKeyPair();
        Key[] keys = new Key[] {pair.getPublic(), pair.getPrivate()};
        FileOutputStream fos = null;
        try{
            for (Key key : keys) {
                String path = null;
                if (key.equals(pair.getPublic())) {
                    path = this.path + "public.key";
                } else {
                    path = this.path + "private.key";
                }
                File file = new File(path);
                fos = new FileOutputStream(file);
                fos.write(key.getEncoded());
            }
        } catch (IOException e) {
                throw e;
            } finally {
                if (fos != null) {
                    fos.close();
                    fos.flush();
                }
            }
    }

    private boolean checkKeyFile() {
        File folder = new File(path);
        if (!folder.exists()) {
            return false;
        } else {
            String[] files = new String[] { path + "public.key", path + "private.key" };
            for (String f : files) {
                File file = new File(f);
                if (!file.exists())
                    return false;
            }
        }
        return true;
    }

    public PublicKey getPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        if (!checkKeyFile()) {
            createKey();
        }
        byte[] publicKeyBytes = Files.readAllBytes(Paths.get(path+"public.key"));
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        return keyFactory.generatePublic(publicKeySpec);
    }

    public PrivateKey getPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
        if (!checkKeyFile()) {
            createKey();
        }
        byte[] privateKeyBytes = Files.readAllBytes(Paths.get(path+"private.key"));
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        return keyFactory.generatePrivate(privateKeySpec);
    }

    public String encryptRSA(String plainText) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, InvalidKeyException, NoSuchPaddingException, BadPaddingException , IllegalBlockSizeException {
        PublicKey publicKey = getPublicKey();
        Cipher encipher = Cipher.getInstance(algorithm);
        encipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytePlain = encipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(bytePlain);
    }

    public String decryptRSA(String encrypted) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        PrivateKey privateKey = getPrivateKey();
        Cipher decipher = Cipher.getInstance(algorithm);
        byte[] byteEncrypted = Base64.getDecoder().decode(encrypted.getBytes());
        decipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytePlain = decipher.doFinal(byteEncrypted);
        return new String(bytePlain, StandardCharsets.UTF_8);
    }

}