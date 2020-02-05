import java.util.*;
public class Agent3 implements Runnable {
	Elevator elevator;
	public boolean a3;
	private int check = 0; 
	private int spawnCheck = 0;
	private int startFloorLevel;
	
	public Agent3(Elevator elevator) {
		this.elevator = elevator;
	}
	
	public void run() {
		int exitCheck = 0;
		while (check == 0){
			if (spawnCheck == 0){
				startFloorLevel = randFloor();
				elevator.startFloor(startFloorLevel, 3);
				spawnCheck = 1;
				
			}
			if (elevator.EnterElevator()){
				elevator.floorstart(startFloorLevel);
				elevator.inElevator = 1;
				elevator.ChooseClearence(randClerance(), 3);
				elevator.SelectedFloor(randFloor(), 2);
				System.out.println("3 running");
				check = 1;
				while(exitCheck != 1) {
					if (!elevator.FloorCheck(elevator.level, elevator.floor)){
						elevator.SelectedFloor(randFloor(), 3);
					}else {
						exitCheck = 1;	
					}
					spawnCheck = 0;
				}
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
  
	public int randClerance() {
		Random rn = new Random();
		int num = rn.nextInt(3) + 1;
		return num;
	}
	
	public int randFloor() {
		Random rn = new Random();
		int num = rn.nextInt(4) + 0;
		return num;
	}
  
}
