package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloMessageTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	// 커스텀 태그의 속성값을 저장하기 위한 필드
	// => ★커스텀 태그의 속성명과 같은 이름으로 필드선언
	private String name;
	
	// 생성자에서는 객체 생성에 필요한 초기화 작업을 해준다. -> 필드 초기값 설정
	public HelloMessageTag() {
		// 커스텀 태그 사용시 속성을 생략할 경우 기본적으로 사용될 속성값으로 필드에 저장
		// => 커스텀 태그의 속성이 필수인 경우 필드 기본값 생략
		name = "홍길동";
	}

	public String getName() {
		return name;
	}
	
	// 커스텀 태그 사용시 속성을 사용하여 속성값을 설정할 경우 Setter 메소드 자동 호출
	public void setName(String name) {
		this.name = name;
	}
	
	//=========================================================================
	// 커스텀 태그 사용시 호출되는 메소드만 오버라이드 선언
	// => 오버라이즈 선언하지 않은 메소드는 부모클래스의 명령이 없는 메소드 호출
	@Override
	public int doStartTag() throws JspException {
		
		try {
			if (name.equals("홍길동")) {
				pageContext.getOut().println("<h3>관리자님, 안녕하세요!</h3>");
			} else {
				pageContext.getOut().println("<h3>"+name+"님, 안녕하세요!</h3>");
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		
		return SKIP_BODY;
	}
	
	

	

}
