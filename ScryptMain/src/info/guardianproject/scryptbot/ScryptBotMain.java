package info.guardianproject.scryptbot;

import com.lambdaworks.crypto.SCryptUtil;

public class ScryptBotMain {
    public static final int ITERATIONS = 1024 * 128;
    public static final int SALT_LENGTH = 8;
    public static int DEFAULT_R = 8;
    public static int DEFAULT_P = 1;
    public static final int KEY_LENGTH = 32;

    public static void main(String[] args) {
        System.out.println("Rehearsal");
        runScrypt();
        System.out.println("Starting");
        long start = System.currentTimeMillis();
        runScrypt();
        long end = System.currentTimeMillis();
        System.out.println("Took " + (end - start) + " millis");
    }

    static void runScrypt() {
        SCryptUtil.scrypt("hello world", ITERATIONS, DEFAULT_R, DEFAULT_P);
    }
}