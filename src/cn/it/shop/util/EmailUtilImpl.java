package cn.it.shop.util;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

@Component("emailUtil")
public class EmailUtilImpl implements EmailUtil {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.it.shop.util.EmailUtil#sendEmail(java.lang.String, int)
	 */
	@Override
	public void sendEmail(String email, String id) {
		Transport transport = null;
		// 登录邮件客户端(创建回话session)
		Properties properties = new Properties();
		// 此属性在getDefaultInstance方法说明中查找
		properties.put("mail.transport.protocol", "smtp");
		/*
		 * //QQ邮箱方案一： MailSSLSocketFactory sf = new MailSSLSocketFactory();
		 * sf.setTrustAllHosts(true); properties.put("mail.smtp.ssl.enable",
		 * "true"); properties.put("mail.smtp.ssl.socketFactory", sf);
		 */
		/*
		 * //QQ邮箱方案二： properties.setProperty("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");
		 * properties.setProperty("mail.smtp.port", "465");
		 * properties.setProperty("mail.smtp.socketFactory.port", "465");
		 */
		// 根据配置文件获取一个session会话
		Session session = Session.getDefaultInstance(properties);
		// 设置debug格式
		session.setDebug(true);
		// 创建一个邮件对象
		Message message = new MimeMessage(session);
		// 设置邮件的标题
		try {
			message.setSubject("我是标题");
			// 设置发送邮箱地址
			message.setFrom(new InternetAddress("1123934927_yh@sina.com"));
			// 设置邮件正文内容
			message.setContent("订单" + id + "已经支付成功！", "text/html;charset=utf-8");
			// 通过sesion获取邮件传输对象
			transport = session.getTransport();
			// 连接到邮件服务器
			transport.connect("smtp.sina.com", "1123934927_yh", "1123934927");
			// 设置发送的邮件和发送地址
			transport.sendMessage(message, new Address[] { new InternetAddress(
					email) });
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException(e);
		} finally {
			try {
				transport.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}
}
