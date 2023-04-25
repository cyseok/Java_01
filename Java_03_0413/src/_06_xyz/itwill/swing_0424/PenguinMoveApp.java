package _06_xyz.itwill.swing_0424;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PenguinMoveApp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// 프레임의 폭과 높이를 저장
	private static final int JFRAME_WIDTH = 646;
	private static final int JFRAME_HEIGHT = 461;
	
	private static final int PENGUIN_SIZE = 60;
	
	// 배경이미지 저장 필드
	// image 클래스 : 그림파일의 정보를 저장하기 위한 클래스
	private Image backImage;
	
	// 팽귄이미지를 저장하기 위한 배열
	private Image[] penguins;
	
	// 팽귄이미지를 선택하기 위한 필드 -> 배열의 첨자
	private int penguinNo;
	
	// 팽귄이미지가 출력될 좌표값을 저장하는 필드
	private int penguinX, penguinY;

	public PenguinMoveApp(String title) {
		super(title);
		
		// 그림파일의 정보를 저장하는 클래스
		// => ImageIcon  : 그림파일의 URL주소를 제공받아 ImageIcon 객체 생성
		// => URL 클래스 : 리소스파일의 경로를 저장하는 클래스
		// => Object.getClass() : 메모리에 저장된 현재 실행 클래스의 Class 객체를 반환하는 메소드
		// => getResource : 리소스 파일을 읽어 URL객체를 반환하는 메소드
		// => ImageIcon.getImage() : ImageIcon 객체에 저장된 그림파일의 Image객체를 반환하는 메소드
		// => 배경이미지 파일을 읽어 배경이미지를 필드에 저장
		backImage = new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
		
		// 팽귄이미지 파일을 읽어 필드 요소에 저장
		penguins = new Image[3];
		for(int i = 0; i < penguins.length; i++) {
			penguins[i] = new ImageIcon(getClass().getResource("/images/penguin" + (i+1) + ".gif")).getImage();
			
			
		}
		
		penguinX = JFRAME_WIDTH / 2 - PENGUIN_SIZE / 2;		
		penguinY = JFRAME_HEIGHT - PENGUIN_SIZE;	
		
		setResizable(false);
		
		//프레임에서 키보드 관련 이벤트가 발생될 경우 이벤트 처리 객체를 사용하여 이벤트 처리
		addKeyListener(new PenguinMoveHandle());
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setBounds(700, 200, 646, 461);
		setBounds(700, 200, JFRAME_WIDTH, JFRAME_HEIGHT);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new PenguinMoveApp("팽귄");
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(backImage, 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT, this);
		
		g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
	}
	
	public class PenguinMoveHandle extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			// KeyEvent.getKeyCode() : 이벤트가 발생된 키보드의 고유값을 반환하는 메소드
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_LEFT:
				penguinX-=10;
				if(penguinX<=0) {
					penguinX=0;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			case KeyEvent.VK_RIGHT:
				penguinX+=10;
				if(penguinX>=JFRAME_WIDTH-PENGUIN_SIZE) {
					penguinX=JFRAME_WIDTH-PENGUIN_SIZE;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			
			}
			
		}
	}
}





























