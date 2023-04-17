package _03_xyz.itwll.lang.thread_0417;

public class MultiThreadOne extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(char i ='a'; i <= 'z'; i++) {
			System.out.print(i);
			
		}
		
	}

}
