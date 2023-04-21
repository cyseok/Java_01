package _05_xyz.itwill.awt_0421;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;

public class MenuBarApp extends Frame {
	
	private static final long serialVersionUID = 1L;
	
	public MenuBarApp(String title) {
		super(title);
		
		MenuBar menuBar = new MenuBar();
		
		
		Menu file = new Menu("File");
		Menu help = new Menu("help");
		
		menuBar.add(file);   // 메뉴바에 메뉴를 배치
		menuBar.add(help);
		
		MenuItem open = new MenuItem("open", new MenuShortcut(KeyEvent.VK_0));
		MenuItem save = new MenuItem("save", new MenuShortcut(KeyEvent.VK_S));
		MenuItem exit = new MenuItem("exit");
		
		MenuItem view = new MenuItem("HelpView");
		MenuItem info = new MenuItem("Infomation");
		
		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		
		help.add(view);
		help.addSeparator();
		help.add(info);
		
		// Frame.setMenuBar(MenuBar bar) : 프레임의 메뉴바를 변경하는 메소드
		setMenuBar(menuBar);
		
		
		
		
		TextArea textArea = new TextArea();
		textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		add(textArea, BorderLayout.CENTER);
		
		
		
		setBounds(500, 10, 1000, 1000);
		setVisible(true);

	
	}
	
	public static void main(String[] args) {
		new MenuBarApp("MenuBar");
				
	}

}
