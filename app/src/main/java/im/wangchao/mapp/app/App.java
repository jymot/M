package im.wangchao.mapp.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import im.wangchao.catcher.Catcher;
import im.wangchao.mapp.core.net.NetworkManager;
import im.wangchao.mrouter.Router;

/**
 * <p>Description  : App.</p>
 * <p>Author       : wangchao.</p>
 * <p>Date         : 2017/12/20.</p>
 * <p>Time         : 上午10:38.</p>
 */
public class App extends Application {
    private volatile static App sAPP;

    public static Application getApplication(){
        return sAPP;
    }

    @Override protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override public void onCreate() {
        super.onCreate();
        sAPP = this;
        Catcher.instance().init(this);
        Router.init();
        NetworkManager.init(this);
    }
}
