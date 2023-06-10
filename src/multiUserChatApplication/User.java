package org.example;

import sop.SOP;

import java.io.IOException;
import java.util.Scanner;

public class User {
    private String userId;
    private byte[] keyId;
    private byte[] certId;
    private String password;
    User () {

    }
    public User (String userId) {
        this.userId = userId;
        this.keyId = getKeyId();

    }

    public byte[] getKeyId() {
        return keyId;
    }

    public byte[] getCertId() {
        return certId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void generateUserKey (String userId, String password, SOP sop) throws IOException {
        keyId = sop.generateKey()
                .userId(userId)
                .withKeyPassword(password)
                .generate()
                .getBytes();

    }
    public void generateUserCert (byte[] keyId, SOP sop) throws IOException {
        certId = sop.extractCert()
                .key(keyId)
                .getBytes();
    }
    public void registrateUser (Scanner sc, SOP sop) throws IOException {
        System.out.println("UserID: ");
        setUserId(sc.nextLine());
        System.out.println("Password: ");
        setPassword(sc.nextLine());
        generateUserKey(getUserId(), getPassword(), sop);
        generateUserCert(getKeyId(), sop);
    }

}
