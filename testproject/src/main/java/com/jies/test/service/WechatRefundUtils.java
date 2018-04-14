///*
// * ====================================================================
// * Licensed to the Apache Software Foundation (ASF) under one
// * or more contributor license agreements.  See the NOTICE file
// * distributed with this work for additional information
// * regarding copyright ownership.  The ASF licenses this file
// * to you under the Apache License, Version 2.0 (the
// * "License"); you may not use this file except in compliance
// * with the License.  You may obtain a copy of the License at
// *
// *   http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing,
// * software distributed under the License is distributed on an
// * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// * KIND, either express or implied.  See the License for the
// * specific language governing permissions and limitations
// * under the License.
// * ====================================================================
// *
// * This software consists of voluntary contributions made by many
// * individuals on behalf of the Apache Software Foundation.  For more
// * information on the Apache Software Foundation, please see
// * <http://www.apache.org/>.
// *
// */
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLContexts;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//import javax.net.ssl.SSLContext;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.security.KeyStore;
//
///**
// * This example demonstrates how to create secure connections with a custom SSL
// * context.
// */
//public class WechatRefundUtils {
//
//    public final static String post(String certName, String mchid,
//                                    String xmlBody, String url) throws Exception {
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        String path = "/Users/peijie/qqqq/";// WechatRefundUtils.class.getClassLoader().getResource("")
//                //.toURI().getPath();
//        System.out.println(path);
//        FileInputStream instream = new FileInputStream(
//                new File(path + certName));
//        try {
//            keyStore.load(instream, mchid.toCharArray());
//        } finally {
//            instream.close();
//        }
//
//        // Trust own CA and all self-signed certs
//        SSLContext sslcontext = SSLContexts.custom()
//                .loadKeyMaterial(keyStore, mchid.toCharArray()).build();
//        // Allow TLSv1 protocol only
//        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
//                sslcontext, new String[]{"TLSv1"}, null,
//                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setSSLSocketFactory(sslsf).build();
//        try {
//
//            HttpPost httpPost = new HttpPost(url);
//            StringEntity stringEntity = new StringEntity(xmlBody, "UTF-8");
//            httpPost.setEntity(stringEntity);
//            httpPost.setHeader("Content-Type","application/json");
//            System.out.println("executing request" + httpPost.getRequestLine());
//            CloseableHttpResponse response = httpclient.execute(httpPost);
//            HttpEntity entity = response.getEntity();
//
//            System.out.println("----------------------------------------");
//            System.out.println(response.getStatusLine());
//            StringBuffer buffer = new StringBuffer("");
//            if (entity != null) {
//                System.out.println("Response content length: "
//                        + entity.getContentLength());
//                BufferedReader bufferedReader = new BufferedReader(
//                        new InputStreamReader(entity.getContent()));
//                String text;
//                while ((text = bufferedReader.readLine()) != null) {
//                    System.out.println(text);
//                    buffer.append(text);
//                }
//
//            }
//            EntityUtils.consume(entity);
//            return buffer.toString();
//        } finally {
//            httpclient.close();
//        }
//    }
//
//}
