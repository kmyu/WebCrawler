/*	
 * file 		 : HttpUtil.java
 * created by    : kmyu
 * creation-date : 2016. 11. 18.
 */

package com.km.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpUtil {

	
    public static String toHtmlStr(String uri) {
        InputStream is = null;
        try {
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(uri);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            StringBuffer out = new StringBuffer();
            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1;) {
                out.append(new String(b, 0, n));
            }
            return out.toString();
        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (is != null) try { is.close(); } catch (Exception e) {}
        }
    }
	
	
	
}

