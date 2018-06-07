package cn.it.shop.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.it.shop.util.MessageUtil#sendMessage(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void sendMessage(String phone, String id) throws Exception {
		// 1、打开浏览器
		HttpClient httpClient = new HttpClient();
		// 2、创建请求的方式，get/post
		PostMethod postMethod = new PostMethod("http://utf8.sms.webchinese.cn");
		// 3、设置请求的参数信息
		postMethod.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		postMethod.setParameter("Uid", "yh_shop_ms");
		postMethod.setParameter("Key", "7398c20a03d9e9646982");
		postMethod.setParameter("smsMob", phone);
		postMethod.setParameter("smsText", "訂單" + id + "已經支付成功");
		// 4、提交请求
		int code = httpClient.executeMethod(postMethod);
		System.out.println("HTTP请求返回的状态码:" + code);
		// 5、获取服务器返回的数据信息
		String result = postMethod.getResponseBodyAsString();
		System.out.println("短信发送结果为：" + result);
	}
}
