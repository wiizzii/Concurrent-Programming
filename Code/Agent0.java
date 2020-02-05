public class Agent0 implements Runnable {
	Elevator elevator;
	ElevatorGUI gui;
	public int startfloor;
	public int clearence;
	public int selectedfloor;
	
	private int check = 0; 
	private int check1 = 1; 
	private int spawnCheck = 0;
	
	public Agent0(Elevator elevator) {
		this.elevator = elevator;
	}
	public void setgui(ElevatorGUI gui){
		this.gui = gui;
		}
	
	public void run() {
		while (check == 0){
			if (spawnCheck == 0){
				elevator.startFloor(startfloor, 0);
				spawnCheck = 1;
			}
			if (elevator.EnterElevator()){
				elevator.floorstart(startfloor);
				elevator.inElevator = 1;
				elevator.ChooseClearence(clearence, 0);
				elevator.SelectedFloor(selectedfloor, 0);
				System.out.println("1 running");
				while (check1 != 0) {
					if (!elevator.FloorCheck(elevator.level, elevator.floor)){
						gui.AgentNewFloor();
						elevator.SelectedFloor(selectedfloor, 1);
					}else {
						gui.NewUserAgent();
						check = 1;
						check1 = 0;
						spawnCheck = 0;
					}
				}
				check1= 1;
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
