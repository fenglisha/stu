package com.jt.web.test;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpUtils;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.media.jfxmedia.control.VideoDataBuffer;

public class TestHttp {
@Test
	public void testurl() throws ClientProtocolException, IOException {
//	获取httpclient对象
	CloseableHttpClient client =
	HttpClients.createDefault();
//	定义url
	String url = "https://item.jd.com/5175698.html";
//	定义请求
	HttpGet httpGet = new HttpGet(url);
//	发起请求，并得到结果
	CloseableHttpResponse httpResponse = 
	client.execute(httpGet);
//结果是否正确
	if(httpResponse.getStatusLine().getStatusCode()==200) {
//		得到换回entity对象
		 HttpEntity httpEntity = 
		httpResponse.getEntity();
//		 将结果转化成字符串，http提供了Entity工具包；
		String result = EntityUtils.toString(httpEntity);
//		打印结果
		System.out.println(result);
		
	}else {

	throw new RuntimeException("请求失败");
	}
  }

    @Test
	public void test001() {
		Cookie cookie = new Cookie("age", "123");
		System.out.println(cookie.getName()+cookie.getValue());
		
	}
}

