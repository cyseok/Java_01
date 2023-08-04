package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailSendApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-3_email.xml");
		EmailSendBean bean=context.getBean("emailSendBean", EmailSendBean.class);
		System.out.println("================================================================");
		bean.sendEmail("gudtjq0306@gmail.com", "악마의 편지", "<h1>10분안에 3명에게 이 메일을 보내지 않으면 죽습니다 <h1>");
		System.out.println("================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}