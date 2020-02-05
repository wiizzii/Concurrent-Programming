public class Agent1 implements Runnable {
	Elevator elevator;
	private int check = 0; 
	private int spawnCheck = 0;
	
	public Agent1(Elevator elevator) {
		this.elevator = elevator;
	}
	
	public void run() {
		while (check == 0){
			if (spawnCheck == 0){
				elevator.startFloor(0, 1);
				spawnCheck = 1;
			}
			if (elevator.EnterElevator()){
				elevator.floorstart(0);
				elevator.inElevator = 1;
				elevator.ChooseClearence(1, 1);
				elevator.SelectedFloor(2, 1);
				System.out.println("1 running");
				if (!elevator.FloorCheck(elevator.level, elevator.floor)){
					elevator.SelectedFloor(0, 1);
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
