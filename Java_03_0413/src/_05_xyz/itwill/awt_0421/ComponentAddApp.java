package _05_xyz.itwill.awt_0421;

import java.awt.Button;
import java.awt.Frame;

public class ComponentAddApp extends Frame {
	
	private static final long serialVersionUID = 1L;
	
	 public ComponentAddApp(String title) {
		 super(title);
		 
		 Button button = new Button("버튼");
		 
		 // container.add(Component c) : 컨테이너에 컴퍼넌트를 배치하는 메소드
		 // => 컨테이너에 설정된 배치관리자(LayoutManager)에 의해 컴퍼넌트가 자동 배치
		 add(button);
		 
		 setBounds(600, 100, 300, 300);
		 
		 setVisible(true);
		 
	}
	 
	 public static void main(String[] args) {
		new ComponentAddApp("컴퍼넌트 배치");
		
	}

	 
	 
	

}
