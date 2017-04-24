package tomcat360.com.hyxfjr.net;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Title:MyObserver
 * Package:com.tomcat360.net
 * Description:TODO
 * Author: llj@tomcat360.com
 * Date: 2017/3/27
 * Version: V1.0.0
 * 版本号修改日期修改人修改内容
 */

public abstract class MyObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
