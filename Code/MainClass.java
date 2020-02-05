public class MainClass{

public static void main(String[] args){
		
		Elevator elevator = new Elevator();
		Agent0 agent0 = new Agent0(elevator);
		Agent1 agent1 = new Agent1(elevator);
		Agent2 agent2 = new Agent2(elevator);
		Agent3 agent3 = new Agent3(elevator);
		ElevatorGUI gui = new ElevatorGUI(elevator);
		elevator.setgui(gui);
		gui.setagent0(agent0);
		gui.setagent1(agent1);
		gui.setagent2(agent2);
		gui.setagent3(agent3);
		agent0.setgui(gui);
	}
}
