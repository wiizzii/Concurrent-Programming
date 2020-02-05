public class Agent2 implements Runnable {
	Elevator elevator;
	private int check = 0; 
	private int spawnCheck = 0;
	
	public Agent2(Elevator elevator) {
		this.elevator = elevator;
	}
	
	public void run() {
		while (check == 0){
			if (spawnCheck == 0){
				elevator.startFloor(2, 2);
				spawnCheck = 1;
			}
			if (elevator.EnterElevator()){
				elevator.floorstart(2);
				elevator.inElevator = 1;
				elevator.ChooseClearence(3, 2);
				elevator.SelectedFloor(3, 2);
				System.out.println("2 running");
				if (!elevator.FloorCheck(elevator.level, elevator.floor)){
					elevator.SelectedFloor(0, 2);
				}
				check = 1;
				spawnCheck = 0;
			}else{
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
		}
		check = 0;
	}
}
