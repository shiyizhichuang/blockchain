package config;

import com.jfinal.config.*;
import com.jfinal.template.Engine;
import controller.HelloController;

/**
 * Created by mac on 2017/3/14.
 */
public class CommonConfig extends JFinalConfig {
    public void configConstant(Constants constants) {

    }

    public void configRoute(Routes routes) {
        routes.add("hello", HelloController.class);
    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {

    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }
}
