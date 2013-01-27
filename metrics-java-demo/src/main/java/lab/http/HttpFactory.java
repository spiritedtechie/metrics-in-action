package lab.http;

import org.apache.http.client.HttpClient;

import com.yammer.metrics.httpclient.InstrumentedHttpClient;

public class HttpFactory {

    private static HttpClient httpClient;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Shutting down http client");
                if (httpClient != null) {
                    httpClient.getConnectionManager().shutdown();
                }
            }
        }));
    }

    public static HttpClient getHttp() {

        if (httpClient == null) {
            httpClient = new InstrumentedHttpClient();
        }

        return httpClient;
    }

}
