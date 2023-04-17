package _03_xyz.itwll.lang.thread_0417;

public class MultiThreadTwo implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(char i ='0'; i <= '9'; i++) {
			System.out.print(i);
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
			
		}
		
	}

}
