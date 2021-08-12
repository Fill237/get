import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {

    static  String sUrl = "http://speller.yandex.net/services.spellservice";

    public static void main(String[] args) {
        CloseableHttpResponse resp1 = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(sUrl + "/checkText?text=Усталый+гребник+вышол+из+леса");

            resp1 = httpClient.execute(httpGet);

            System.out.println(EntityUtils.toString (resp1.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resp1.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}





