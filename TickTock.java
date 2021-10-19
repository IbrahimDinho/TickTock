// Tick Tock program which simulates a clock with each tick tock being one second (excluding time for context switch).

public class TickTock {
	// threads will need to share the state.
	String state; // state of the clock which is used as condition for wait and when to call notify.

	synchronized void tick(boolean running){
		// this is stop hanging and make sure so no threads are waiting in the end
		if (!running) {
			state = "ticked";
			notify();
			return;
		}

		System.out.print("Tick");
		// wait 1/2 a second 500 milliseconds
		try{
			Thread.sleep(500); 
		} catch (InterruptedException exc){
			System.out.println("Thread interrupted");
		}
		state = "ticked";

		notify(); // allow for the tock thread to wake up if its sleeping
		try{
		// wait for tock thread to complete and notifiy this thread so when state becomes tocked you no longer need to wait.
		while(!state.equals("tocked")){
			wait();
		}
	}
	catch(InterruptedException e){
		System.out.println("Thread interrupted");
	}
	}

	// almost mirror of tick.
	synchronized void tock(boolean running){
		if (!running){
			state = "tocked";
			notify();
			return;
		}
	System.out.println("Tock");
	// wait 1/2 a second 500 milliseconds
		try{
			Thread.sleep(500); 
		} catch (InterruptedException exc){
			System.out.println("Thread interrupted");
		}

	state = "tocked";
	notify();
	try{
		while(!state.equals("ticked")){
		wait();
	}
	} catch(InterruptedException exc){
		System.out.println("Thread interrupted");
	}
	
	}
}
