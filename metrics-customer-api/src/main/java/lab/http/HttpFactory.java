package lab.http;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HttpFactory {

    private final HttpClient httpClient;

    @Autowired
    public HttpFactory(HttpClient httpClient) {
        this.httpClient = httpClient;

        addHookToShutdownConnectionManager();
    }

    private void addHookToShutdownConnectionManager() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                if (httpClient != null) {
                    httpClient.getConnectionManager().shutdown();
                }
            }
        }));
    }

    public HttpClient getHttp() {
        return httpClient;
    }

}
