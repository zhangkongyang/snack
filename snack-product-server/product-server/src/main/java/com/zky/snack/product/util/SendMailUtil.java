package com.zky.snack.product.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix="spring.mail")
public class SendMailUtil {
	
	@Value("${spring.mail.username}")
	private String username; // 发件箱
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	
	/**
	 * 发送HTML格式的邮件
	 * @param receiveEmail
	 * @param nickName
	 * @param code
	 * @return
	 */
	public boolean sendHtmlMail(String receiveEmail, String nickName, String code) {
		if (StringUtil.checkNull(receiveEmail, nickName, code)) {
			return false;
		}
		
		try {
		
			
			// 建立邮件的消息，我们需要发送的是html格式邮件		
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			
			// 设置收件人，寄件人
			messageHelper.setTo(receiveEmail);
			messageHelper.setFrom(username);
			messageHelper.setSubject("获奖中心");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			String str = "<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body><p style='font-size: 20px;font-weight:bold;'>尊敬的："+nickName+"，您好！</p>"
					+ "<p style='text-indent:2em; font-size: 20px;'>恭喜你被本公司抽选为幸运用户,这是你的奖品兑换神秘代码	"
					+ "<span style='font-size:30px;font-weight:bold;color:red'>"+code+"</span>，快点击右下角去领取吧！</p>"
					+ "<p style='text-align:right; padding-right: 20px;'>"
					+ "<a href='http://47.115.91.85:8080/image/%E5%B2%B3%E9%98%B3%E5%B8%82%E9%92%9F%E7%BA%AF%E5%90%9B.jpg' style='font-size:18px'>点击有惊喜（放心没病毒）</a></p>"
					+ "<span style='font-size:18px; float:right; margin-right: 60px;'>"+sdf.format(new Date())+"</span></body></html>";
				
			// 设置邮件正文
			messageHelper.setText(str, true);

			
			
			
			
			mailSender.send(mimeMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
