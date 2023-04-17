package _03_xyz.itwll.lang.thread_0417;

public class MultiThreadOne extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(char i ='a'; i <= 'z'; i++) {
			System.out.print(i);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// => throws InterruptedException 사용해버리면 오버라이드가 되지 않는다.
			// try catch 사용해야한다.
			
			
		}
		
	}

}
