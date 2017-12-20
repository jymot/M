package im.wangchao.mapp.core.net;

import android.app.Application;

import im.wangchao.mapp.app.Config;
import im.wangchao.mhttp.MHttp;
import im.wangchao.mhttp.internal.cookie.PersistentCookieJar;
import im.wangchao.mhttp.internal.cookie.cache.SetCookieCache;
import im.wangchao.mhttp.internal.cookie.persistence.SharedPrefsCookiePersistor;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;

/**
 * <p>Description  : Network.</p>
 * <p>Author       : wangchao.</p>
 * <p>Date         : 2017/12/20.</p>
 * <p>Time         : 上午11:10.</p>
 */
public class NetworkManager {

    public static void init(Application app){
        //初始化Http
        CookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(app.getApplicationContext()));
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .cookieJar(cookieJar);

        MHttp.cache(app.getApplicationContext(), builder, Config.appName());

        OkHttpClient okHttpClient = builder.build();
        MHttp.instance().client(okHttpClient);
    }
}
