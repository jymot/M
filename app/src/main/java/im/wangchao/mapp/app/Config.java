package im.wangchao.mapp.app;

import im.wangchao.mapp.BuildConfig;

/**
 * <p>Description  : Config.</p>
 * <p>Author       : wangchao.</p>
 * <p>Date         : 2017/12/20.</p>
 * <p>Time         : 上午11:11.</p>
 */
public class Config {
    private Config(){
        throw new AssertionError();
    }

    public static String appName(){
        return BuildConfig.VERSION_NAME;
    }
}
