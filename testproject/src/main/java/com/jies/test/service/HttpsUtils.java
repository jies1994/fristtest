//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.util.EntityUtils;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
///**
// * Created by peijie on 17/1/11.
// */
//public class HttpsUtils {
//
//    public static String post(String certPath, String certPassword, String jsonBody, String url) throws Exception {
//
//        RecyclerClientSSLPool recyclerClientSSLPool = new RecyclerClientSSLPool(certPath, certPassword);
//        CloseableHttpClient httpclient = recyclerClientSSLPool.getConnection();
//        HttpPost httpPost = new HttpPost(url);
//        StringEntity stringEntity = new StringEntity(jsonBody, "UTF-8");
//        stringEntity.setContentType("application/json");
//        httpPost.setEntity(stringEntity);
//        System.out.println("executing request" + httpPost.getRequestLine());
//        CloseableHttpResponse response = httpclient.execute(httpPost);
//        HttpEntity entity = response.getEntity();
//
//        System.out.println("----------------------------------------");
//        System.out.println(response.getStatusLine());
//        StringBuffer buffer = new StringBuffer("");
//        if (entity != null) {
//            System.out.println("Response content length: "
//                    + entity.getContentLength());
//            BufferedReader bufferedReader = new BufferedReader(
//                    new InputStreamReader(entity.getContent()));
//            String text;
//            while ((text = bufferedReader.readLine()) != null) {
//                System.out.println(text);
//                buffer.append(text);
//            }
//
//        }
//        EntityUtils.consume(entity);
//        return buffer.toString();
//
//
//    }
//}
