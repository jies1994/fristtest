//
//import java.io.File;
//import java.io.FileInputStream;
//import java.security.KeyStore;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//
//import javax.net.ssl.SSLContext;
//
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.config.SocketConfig;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.TrustStrategy;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.ssl.SSLContextBuilder;
//import org.apache.http.ssl.SSLContexts;
//
//public class RecyclerClientSSLPool {
//
//    private PoolingHttpClientConnectionManager poolConnManager = null;
//    private  RequestConfig requestConfig=null;
//
//    private static final int maxConPerRoute = 100;
//    private static final int maxTotalPool = 100;
//    private static final int socketTimeout = 30000;
//    private static final int connectionRequestTimeout = 30000;
//    private static final int connectTimeout = 30000;
//
//    public RecyclerClientSSLPool(String KEY_STORE_PATH, String KEY_STORE_PASSWORD) throws Exception {
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        keyStore.load(new FileInputStream(new File(KEY_STORE_PATH)), KEY_STORE_PASSWORD.toCharArray());
//
//        SSLContextBuilder sslContextBuilder = SSLContexts.custom();
//        sslContextBuilder.loadKeyMaterial(keyStore, KEY_STORE_PASSWORD.toCharArray());
//        // 忽略掉对服务器端证书的校验
//        sslContextBuilder.loadTrustMaterial(new TrustStrategy() {
//            @Override
//            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//                return true;
//            }
//        });
//
//        SSLContext sslcontext = sslContextBuilder.build();
//        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
//        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
//                .register("http", PlainConnectionSocketFactory.INSTANCE).register("https", sslsf).build();
//
//        poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
//        // Increase max total connection to 200
//        poolConnManager.setMaxTotal(maxTotalPool);
//        // Increase default max connection per route to 20
//        poolConnManager.setDefaultMaxPerRoute(maxConPerRoute);
//
//        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(socketTimeout).build();
//        poolConnManager.setDefaultSocketConfig(socketConfig);
//
//        requestConfig = RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout)
//                .setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
//    }
//
//    public CloseableHttpClient getConnection() {
//
//        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(poolConnManager)
//                .setDefaultRequestConfig(requestConfig).build();
//
//        return httpClient;
//    }
//
//
//    public RequestConfig getRequestConfig() {
//        return requestConfig;
//    }
//}
