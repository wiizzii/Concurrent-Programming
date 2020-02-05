import java.util.*;

public class Elevator {
	ElevatorGUI gui;
	public int start;
	public int level;
	public int floor;
	public int inElevator = 0;
	public int okToExit;
	public int agentNr;
	
	/*public Elevator(){
		
	}*/
		
	public void setgui(ElevatorGUI gui){
		this.gui = gui;
		
	}
	
	public void startFloor(int startfloor, int agentNr) {
		gui.ElevatorPre(agentNr, startfloor);
	}
	
	public void floorstart(int startfloor) {
		start = startfloor;
	}
	
	public boolean EnterElevator() {
		Random rn = new Random();
		int time = rn.nextInt(10) + 1;
		try {
			Thread.sleep(time);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		if (inElevator == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void ChooseClearence(int clearenceLevel, int agentnr){
		level = clearenceLevel;
		agentNr = agentnr;
		gui.ElevatorEnter(agentNr);
	}
		
	public void SelectedFloor(int floorSelected, int agent) {
		floor = floorSelected;
		if (inElevator != 0 && level != 0){
			gui.ElevatorRun(agent);
		}
	}
		
	public int TjeckClerance(int level) {
		if (level == 1){
			return 0;
		}else if(level == 2) {
			return 1;
		}else {
			return 3;
		}
	}
		
	public boolean FloorCheck(int level, int floor) {
		if (TjeckClerance(level) >= floor) {
			return true;
		}else{
			return false;
		}
	}
		
	public void ExitOk(int possible) {
			okToExit = possible;
	}
	
}
