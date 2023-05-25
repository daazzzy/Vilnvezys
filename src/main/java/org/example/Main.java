package org.example;

import org.pgpainless.sop.SOPImpl;
import sop.SOP;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        SOP sop = new SOPImpl();
        byte[] keyBytes = sop.generateKey()
                .userId("John Doe <john.doe@pgpainless.org>")
                .withKeyPassword("f00b4r")
                .generate()
                .getBytes();

    }
}