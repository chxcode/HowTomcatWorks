package ex03.pyrmont.startup;

import ex03.pyrmont.connector.http.HttpConnector;

/**
 * @ClassName BootStarp
 * @Description 启动类
 * @Author changxuan
 * @Date 2020/8/13 下午9:50
 **/
public final class BootStrap {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
