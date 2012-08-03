package info.guardianproject.scryptbot;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.lambdaworks.crypto.SCryptUtil;

public class ScryptBotActivity extends Activity {
    public static final int ITERATIONS = 1024 * 16;
    public static int DEFAULT_R = 8;
    public static int DEFAULT_P = 1;
    public static final int KEY_LENGTH = 32;

    @Override
    protected void onResume() {
        super.onResume();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("ScryptBot", "Rehearsal");
                runScrypt();
                Log.i("ScryptBot", "Starting");
                long start = System.currentTimeMillis();
                runScrypt();
                long end = System.currentTimeMillis();
                Log.i("ScryptBot", "Took " + (end - start) + " millis");
            }
        }).start();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    void runScrypt() {
        SCryptUtil.scrypt("hello world", ITERATIONS, DEFAULT_R, DEFAULT_P);
    }
}