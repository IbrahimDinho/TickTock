
public class Driver{
	public static void main(String[] args){
		TickTock tt = new TickTock();

		MyThread thrd1 = new MyThread("Tick", tt);
		MyThread thrd2 = new MyThread("Tock", tt);

		// wait till thread ends before exit Main thread
		try{
			thrd1.thrd.join();
			thrd2.thrd.join();

		} catch(InterruptedException exc){
			System.out.println("Main thread interrupted");
		}
	}
}