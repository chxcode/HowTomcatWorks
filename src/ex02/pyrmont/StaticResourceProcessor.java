package ex02.pyrmont;

/**
 * @ClassName StaticResourceProcessor
 * @Description
 * @Author changxuan
 * @Date 2020/8/11 下午10:18
 **/
public class StaticResourceProcessor {
    public void process(Request request, Response response){
        try {
            response.sendStaticResource();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
