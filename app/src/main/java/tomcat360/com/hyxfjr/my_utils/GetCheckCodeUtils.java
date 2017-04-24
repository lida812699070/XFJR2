package tomcat360.com.hyxfjr.my_utils;

import android.widget.Button;

import com.jiongbull.jlog.JLog;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/4/21 0021.
 */

public class GetCheckCodeUtils {
    public static Disposable getCheckCode(final long count, final Button mSend, final int colorInt) {
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(count + 1)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(@NonNull Long aLong) throws Exception {
                        return count - aLong;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        mSend.setEnabled(false);
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        mSend.setText("剩余" + aLong + "秒");
                        JLog.e("剩余" + aLong + "秒");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        mSend.setEnabled(true);
                        mSend.setTextColor(colorInt);
                        mSend.setText("发送验证码");
                    }
                });


    }
}
