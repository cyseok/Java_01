package xyz.itwill10.controller;
//
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//
//요청 처리 메소드에 의해 처리된 결과를 뷰(JSP 문서)에 제공하는 방법
//방법1. ModelAndView 객체에 처리결과를 속성값으로 저장하여 제공
//방법2. HttpServletRequest 객체에 처리결과를 속성값으로 저장하여 제공
//방법3. Model 객체에 처리결과를 속성값으로 저장하여 제공(가장 효율적인 방법)
//
@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMAV")//클라이언트가 /resultMAV로 요청해야함
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		//→ ModelAndView 객체에 속성명과 속성값을 저장하기 위한 메소드 - Request Scope
		//→ 뷰(JSP 문서)에서는 EL 표현식으로 속성명을 사용하여 속성값을 제공받아 출력
		modelAndView.addObject("mavName", "홍길동");
		return modelAndView;
	}
	*/
	//다른 방법
	//요청 처리 메소드는 Front Controller에 의해 자동 호출되는 메소드
	//→ 요청 처리 메소드에 매개변수를 작성하면 Front Controller는 스프링 컨테이너로부터 매개변수에 저장 가능한 객체를 제공받아 전달 
	@RequestMapping("/resultMAV")//클라이언트가 /resultMAV로 요청해야함
	public ModelAndView mdelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");//JSP 이름
		modelAndView.addObject("mavName", "홍길동");
		return modelAndView;
	}
	//
	@RequestMapping("/resultRequest")//클라이언트가 /resultMAV로 요청해야함
	public String requestResult(HttpServletRequest request) {
		//HttpServletRequest.setAttribute(String attributeName, Object attributeValue)
		//→ HttpServletRequest 객체에 속성명과 속성값을 저장하기 위한 메소드 - Request Scope
		request.setAttribute("requestName", "임꺽정");
		return "result_display";
	}
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		//Model 객체 : 처리결과를 속성값으로 저장하여 뷰(View)에게 제공하기 위한 객체
		//Model.addAttribute(String attributeName, Object attributeValue)
		//→ Model 객체에 속성명과 속성값을 저장하기 위한 메소드 - Request Scope
		model.addAttribute("modelName", "전우치");
		return "result_display";
	}
}