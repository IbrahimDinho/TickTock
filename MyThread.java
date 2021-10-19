
public class MyThread implements Runnable{
	Thread thrd;
	TickTock tickTockObj;

	// construct thread
	MyThread(String name, TickTock tt){
		tickTockObj = tt;
		thrd = new Thread(this, name);
		thrd.start(); // start new thread or a path of execution.
	}
	// threads enters here
	public void run(){

		// returns 0 if true.
		if (thrd.getName().compareTo("Tick") == 0){
			// print tick 5 times
			for (int i=0; i < 5; i++) tickTockObj.tick(true);
			// make sure to notifiy other waiting thread.
			tickTockObj.tick(false);
		}
		else{
			// print tock 5 times.
			for (int i=0;i<5;i++) tickTockObj.tock(true);

			tickTockObj.tick(false);
		}
	}
}