package xyz.itwill10.controller;
//
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import xyz.itwill10.dto.Hewon;
//
@Controller
//@SessionAttributes : Model 객체를 사용하여 저장되는 속성값을 모든 요청 처리 클래스(Controller 클래스)의 현재 요청 처리 메소드와 뷰에게 제공하는 어노테이션
//→ Model 객체를 사용하여 저장되는 속성값을 Request Scope 속성값이 아닌 제한적인 Session Scope 속성값으로 변환하여 제공하는 어노테이션
//→ 변경 처리시 호출되는 요청 처리 메소드에서 변경할 객체를 검색하지 않고 뷰에서는 값을 전달하지 않도록 제한적인 Session Scope 속성값 사용
//→ value 속성 : 제한적인 Session Scope 속성값으로 변환하기 위한 속성명을 속성값으로 설정
//→ 다른속성이 없는 경우 속성값만 설정 가능
@SessionAttributes(value = "hewon")
public class SessionController {
	//아이디를 전달받아 회원정보를 검색하여 반환하는 메소드 - Service 클래스의 메소드
	private Hewon getHewon(String id) {
		Hewon hewon=new Hewon();
		hewon.setId(id);
		hewon.setName("홍길동");
		hewon.setEmail("abc@itwill.xyz");
		return hewon;
	}
	//요청 처리 메소드 작성
	//아이디를 전달받아 회원정보를 뷰에게 제공하기 위한 요청 처리 메소드
	//→ 요청 처리 메소드에 의해 제공된 회원정보가 출력되도록 뷰 작성
	@RequestMapping("/hewon_view")
	public String view(@RequestParam(defaultValue = "abc123") String id, Model model) {
		//Service 클래스의 메소드를 호출하여 아이디를 전달해 해당 아이디의 회원정보를 검색하여 반환받아 저장
		Hewon hewon=getHewon(id);
		//
		//Model 객체를 사용하여 검색된 회원정보를 속성값으로 저장하여 뷰에게 제공
		//→ 요청 처리 메소드의 뷰에게만 속성ㄱ밧을 제공하여 출력 처리 - Request Scope
		//model.addAttribute("hewon", hewon);
		//속성값으로 저장된 객체의 자료형(클래스의 이름 - 첫문자는 소문자로 변환)이 자동으로 속성명으로 설정
		//
		model.addAttribute(hewon);//속성명 생략 가능
		//@SessionAttributes 어노테이션에 의해 Model 객체로 저장된 속성값은 제한적인 Session Scope 속성값으로
		//	변환되어 현재 요청 처리 클래스의 모든 요청 처리 메소드와 뷰에게 속성값 제공
		return "hewon_view";
	}
	/*
	//아이디를 전달받아 회원정보를 뷰에게 제공하기 위한 요청 처리 메소드
	//→ 요청 처리 메소드에 의해 제공된 회원정보를 입력태그의 초기값으로 사용되도록 뷰 작성
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String update(@RequestParam(defaultValue = "abc123") String id, Model model) {
		Hewon hewon=getHewon(id);
		model.addAttribute(hewon);
		return "hewon_update";
	}
	*/
	//@SessionAttributes 어노테이션에 의해 제공된 회원정보를 요청 처리 메소드와 뷰에서 사용 가능
	//→ 아이디를 전달받아 회원정보를 검색하는 명령과 뷰에게 제공하기 위한 속성값 저장 불필요
	@RequestMapping(value="/hewon_update", method = RequestMethod.GET)
	public String update() {
		return "hewon_update";
	}
	//
	//회원정보를 전달받아 변경된 회원정보를 뷰에게 제공하는 요청 처리 메소드
	//→ 요청 처리 메소드의 매개변수에는 Command 객체로 @SessionAttributes 어노테이션에 의해 제공된 회원정보를 전달받아 저장하고 변경값으로 필드값만 변경해 사용
	//요청 처리 메소드에 SessionStatus 인터페이스로 매개변수를 선언하면 SessionStatus 객체를 제공받아 사용 가능
	//→ SessionStatus 객체 : @SessionAttributes 어노테이션에 의해 제공된 제한적인 Session Scope 속성값의 상태정보를 저장하기 위한 객체
	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String update(@ModelAttribute Hewon hewon, SessionStatus status) {
		//SessionStatus.setComplete() : @SessionAttributes 어노테이션에 의해 제공된 제한적인 Session Scope 속성값을 제거하는 메소드
		status.setComplete();
		return "hewon_result";
	}
}