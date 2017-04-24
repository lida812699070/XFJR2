package tomcat360.com.hyxfjr.my_utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;

import static util.SPUtils.FILE_NAME;

/**
 * Created by lida on 2017/4/23 0023.
 */

public class BitmapUtils {
    public String bitmap2StrByBase64(Bitmap bit) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
        byte[] bytes = bos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public Bitmap file2Bitmap(String filePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        return bitmap;
    }

    public static Bitmap convertToBitmap(int w, int h) {
        String path = Environment.getExternalStorageDirectory().toString() + FILE_NAME;
        BitmapFactory.Options opts = new BitmapFactory.Options();
        // 设置为ture只获取图片大小
        opts.inJustDecodeBounds = true;
        opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
        // 返回为空
        BitmapFactory.decodeFile(path, opts);
        int width = opts.outWidth;
        int height = opts.outHeight;
        float scaleWidth = 0.f, scaleHeight = 0.f;
        if (width > w || height > h) {
            // 缩放
            scaleWidth = ((float) width) / w;
            scaleHeight = ((float) height) / h;
        }
        opts.inJustDecodeBounds = false;
        float scale = Math.max(scaleWidth, scaleHeight);
        opts.inSampleSize = (int) scale;
        WeakReference<Bitmap> weak = new WeakReference<Bitmap>(
                BitmapFactory.decodeFile(path, opts));
        return Bitmap.createScaledBitmap(weak.get(), w, h, true);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // 源图片的高度和宽度
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            // 一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    //压缩到指定像素
    public static Bitmap compressBitmap(String filePath, int disWith, int disHight) {
        File myCaptureFile = new File(filePath);
        BitmapFactory.Options options = new BitmapFactory.Options();
//      第一次：设为true时，仅仅得到边界，即宽高
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(myCaptureFile.getAbsolutePath(), options);
//      第二次：将options的值设为Config.RGB_565，会比默认的Config.ARGB_8888减少一半内存；
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        //想压缩到多少像素
        // options.inSampleSize = Math.max(options.outWidth, options.outHeight) / 500;
        options.inSampleSize = calculateInSampleSize(options, disWith, disHight);
        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFile(myCaptureFile.getAbsolutePath(), options);
        //Toast.makeText(MainActivity.this, options.outWidth+"X"+options.outHeight, Toast.LENGTH_SHORT).show();
        //bitmap = ColorToGray(bitmap);
        return bitmap;
    }
}