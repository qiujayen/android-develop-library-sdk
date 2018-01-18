package android.module.tools;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jay on 2018/1/18 下午2:45
 */
public final class AssetsUtils {

    private AssetsUtils() {

    }

    public static String readFile(Context context, String fileName) {
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open(fileName);
            int length = inputStream.available();
            byte[] buffer = new byte[length];
            //noinspection ResultOfMethodCallIgnored
            inputStream.read(buffer);
            return new String(buffer, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
