import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ElevatorGUI extends JPanel{
	private JFrame Frame;
	private JTextField floorlabel = new JTextField();
	private JTextField clearencelabel = new JTextField();
	private JTextField enterExitlabel = new JTextField();
	private JTextField agentlabel = new JTextField();
	private JTextField agentnumlabel = new JTextField();
	private JTextField useragentlabel = new JTextField();
	Elevator elevator;
	private int check = 0;
	private int agentsIn = 0;
	private int agentcheck1 = 0;
	private int agentcheck2 = 0;
	private int agentcheck3 = 0;
	Agent0 agent0;
	Agent1 agent1;
	Agent2 agent2;
	Agent3 agent3;
	
	JLabel floorsPic = new JLabel(new ImageIcon("floors.png"));		
	JLabel elevatorPic = new JLabel(new ImageIcon("elevator.png"));
	JLabel agent0Pic = new JLabel(new ImageIcon("agent0.png"));
	JLabel agent1Pic = new JLabel(new ImageIcon("agent1.png"));
	JLabel agent2Pic = new JLabel(new ImageIcon("agent2.png"));
	JLabel agent3Pic = new JLabel(new ImageIcon("agent3.png"));
	
	JButton agent1Btn = new JButton("Agent1");
	JButton agent2Btn = new JButton("Agent2");
	JButton agent3Btn = new JButton("Agent3");
	
	JButton userAgentBtn = new JButton("Own agent");
	JButton gBtn = new JButton("Ground floor");
	JButton sfBtn = new JButton("Secret floor");
	JButton t1Btn = new JButton("Secret floor 2");
	JButton t2Btn = new JButton("TOP-Secret floor");
	JButton cBtn = new JButton("Confidential");
	JButton sBtn = new JButton("Secret");
	JButton tBtn = new JButton("TOP-Secret");
	JButton rBtn = new JButton("Run agent");

    public ElevatorGUI(Elevator elevator){
		this.elevator = elevator;
        PrepareGUI();
        display();
    }
    
    public void setagent0(Agent0 agent0){
		this.agent0 = agent0;
		}
    public void setagent1(Agent1 agent1){
		this.agent1 = agent1;
		}
	public void setagent2(Agent2 agent2){
		this.agent2 = agent2;
		}
	public void setagent3(Agent3 agent3){
		this.agent3 = agent3;
		}
		
	private void PrepareGUI(){
		Frame = new JFrame("ElevatorGUI");
		Frame.setResizable(false);
		Frame.setLayout(null);
		
		Insets insets = Frame.getInsets();
        Frame.setSize(1200 + insets.left + insets.right,
                       1000+ insets.top + insets.bottom);
		
		floorlabel.setHorizontalAlignment(JTextField.CENTER);
		floorlabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		floorlabel.setEditable(false);
		floorlabel.setText("Ground floor");
		
		clearencelabel.setHorizontalAlignment(JTextField.CENTER);
		clearencelabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		clearencelabel.setEditable(false);
		
		enterExitlabel.setHorizontalAlignment(JTextField.CENTER);
		enterExitlabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		enterExitlabel.setEditable(false);
		
		agentlabel.setHorizontalAlignment(JTextField.CENTER);
		agentlabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		agentlabel.setEditable(false);
		
		agentnumlabel.setHorizontalAlignment(JTextField.CENTER);
		agentnumlabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		agentnumlabel.setEditable(false);
		
		useragentlabel.setHorizontalAlignment(JTextField.CENTER);
		useragentlabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		useragentlabel.setEditable(false);
		
		Frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});
				
		Frame.setVisible(true); 
	}
	
	private void display(){
		
		Agent1Event Agent1BtnEvent = new Agent1Event();
		agent1Btn.addActionListener(Agent1BtnEvent);
		
		Agent2Event Agent2BtnEvent = new Agent2Event();
		agent2Btn.addActionListener(Agent2BtnEvent);
		
		Agent3Event Agent3BtnEvent = new Agent3Event();
		agent3Btn.addActionListener(Agent3BtnEvent);
	
		userAgentEvent userAgentBtnEvent = new userAgentEvent();
		userAgentBtn.addActionListener(userAgentBtnEvent);
		
		gEvent gBtnEvent = new gEvent();
		gBtn.addActionListener(gBtnEvent);
		
		sfEvent sfBtnEvent = new sfEvent();
		sfBtn.addActionListener(sfBtnEvent);
		
		t1Event t1BtnEvent = new t1Event();
		t1Btn.addActionListener(t1BtnEvent);
		
		t2Event t2BtnEvent = new t2Event();
		t2Btn.addActionListener(t2BtnEvent);
		
		cEvent cBtnEvent = new cEvent();
		cBtn.addActionListener(cBtnEvent);
		
		sEvent sBtnEvent = new sEvent();
		sBtn.addActionListener(sBtnEvent);
		
		tEvent tBtnEvent = new tEvent();
		tBtn.addActionListener(tBtnEvent);
		
		rEvent rBtnEvent = new rEvent();
		rBtn.addActionListener(rBtnEvent);
	
		Frame.add(agentlabel);
		Frame.add(agentnumlabel);
		Frame.add(floorlabel);
		Frame.add(clearencelabel);
		Frame.add(enterExitlabel);
		Frame.add(useragentlabel);
		Frame.add(agent1Btn);
		Frame.add(agent2Btn);
		Frame.add(agent3Btn);
		
		Frame.add(agent0Pic);
		Frame.add(agent1Pic);
		Frame.add(agent2Pic);
		Frame.add(agent3Pic);
		Frame.add(elevatorPic);
		Frame.add(floorsPic);
		
		Frame.add(userAgentBtn);
		Frame.add(gBtn);
		Frame.add(sfBtn);
		Frame.add(t1Btn);
		Frame.add(t2Btn);
		Frame.add(cBtn);
		Frame.add(sBtn);
		Frame.add(tBtn);
		Frame.add(rBtn);
		
		useragentlabel.setText("Make own agent:");
		agentlabel.setText("Number og agents: ");
		agentnumlabel.setText("" + agentsIn);
		
		agent0Pic.setVisible(false);
		agent1Pic.setVisible(false);
		agent2Pic.setVisible(false);
		agent3Pic.setVisible(false);
		
		gBtn.setVisible(false);
		sfBtn.setVisible(false);
		t1Btn.setVisible(false);
		t2Btn.setVisible(false);
		cBtn.setVisible(false);
		sBtn.setVisible(false);
		tBtn.setVisible(false);
		rBtn.setVisible(false);
		
		Insets insets = Frame.getInsets();
        //label:
        agentlabel.setBounds(1010 + insets.left, 20 + insets.top, 170, 30);
        agentnumlabel.setBounds(1010 + insets.left, 50 + insets.top, 170, 30);
        clearencelabel.setBounds(25 + insets.left, 50 + insets.top, 150, 30);
        enterExitlabel.setBounds(25 + insets.left, 80 + insets.top, 150, 30);
        floorlabel.setBounds(25 + insets.left, 110 + insets.top, 150, 30);    
		//agent buttons:
        agent1Btn.setBounds(25 + insets.left, 200 + insets.top, 150, 25);
        agent2Btn.setBounds(25 + insets.left, 230 + insets.top, 150, 25);
        agent3Btn.setBounds(25 + insets.left, 260 + insets.top, 150, 25);
        elevatorPic.setBounds(226 + insets.left, 44 + insets.top, 119, 203);
        floorsPic.setBounds(200 + insets.left, 10 + insets.top,800, 950);
        
        useragentlabel.setBounds(1020 + insets.left, 85 + insets.top, 150, 30);
        userAgentBtn.setBounds(1020 + insets.left, 120 + insets.top, 150, 25);
        gBtn.setBounds(1020 + insets.left, 120 + insets.top, 150, 25);
        sfBtn.setBounds(1020 + insets.left, 150 + insets.top, 150, 25);
        t1Btn.setBounds(1020 + insets.left, 180 + insets.top, 150, 25);
        t2Btn.setBounds(1020 + insets.left, 210 + insets.top, 150, 25);
        cBtn.setBounds(1020 + insets.left, 120 + insets.top, 150, 25);
        sBtn.setBounds(1020 + insets.left, 150 + insets.top, 150, 25);
        tBtn.setBounds(1020 + insets.left, 180 + insets.top, 150, 25);
        rBtn.setBounds(1020 + insets.left, 120 + insets.top, 150, 25);
	}
	
	public class Agent1Event implements ActionListener{
		public void actionPerformed(ActionEvent Agent1BtnEvent){
			System.out.println("1: " + agentcheck1);
			if (agentcheck1 == 0) {
				Thread agent01 = new Thread(agent1);
				agent01.start();
				agentcheck1 += 1;
			}
		}
	}
	
	public class Agent2Event implements ActionListener{
		public void actionPerformed(ActionEvent Agent2BtnEvent){
			System.out.println("2: " + agentcheck2);
			if (agentcheck2 == 0) {
				Thread agent02 = new Thread(agent2);
				agent02.start();
				agentcheck2 += 1;
			}
		}
	}
	
	public class Agent3Event implements ActionListener{
		public void actionPerformed(ActionEvent Agent3BtnEvent){
			System.out.println("3: " + agentcheck3);
			if (agentcheck3 == 0) {
				Thread agent03 = new Thread(agent3);
				agent03.start();
				agentcheck3 += 1;
			}
		}
	}
	
	public class userAgentEvent implements ActionListener{
		public void actionPerformed(ActionEvent userAgentBtnEvent){
				gBtn.setVisible(true);
				sfBtn.setVisible(true);
				t1Btn.setVisible(true);
				t2Btn.setVisible(true);
				userAgentBtn.setVisible(false);
				useragentlabel.setVisible(false);
		}
	}
	
	public class gEvent implements ActionListener{
		public void actionPerformed(ActionEvent gBtnEvent){
			if(check == 0) {
				agent0.startfloor = 0;
				check = 1;
				cBtn.setVisible(true);
				sBtn.setVisible(true);
				tBtn.setVisible(true);
				gBtn.setVisible(false);
				sfBtn.setVisible(false);
				t1Btn.setVisible(false);
				t2Btn.setVisible(false);
			}else if (check == 2){
				agent0.selectedfloor = 0;
			} else {
				agent0.selectedfloor = 0;
				rBtn.setVisible(true);
				gBtn.setVisible(false);
				sfBtn.setVisible(false);
				t1Btn.setVisible(false);
				t2Btn.setVisible(false);
			}
		}
	}
	
	public class sfEvent implements ActionListener{
		public void actionPerformed(ActionEvent sfBtnEvent){
			if(check == 0) {
				agent0.startfloor = 1;
				check = 1;
				cBtn.setVisible(true);
				sBtn.setVisible(true);
				tBtn.setVisible(true);
				gBtn.setVisible(false);
				sfBtn.setVisible(false);
				t1Btn.setVisible(false);
				t2Btn.setVisible(false);
			}else if (check == 2){
				agent0.selectedfloor = 1;
			} else {
				agent0.selectedfloor = 1;
				rBtn.setVisible(true);
				gBtn.setVisible(false);
				sfBtn.setVisible(false);
				t1Btn.setVisible(false);
				t2Btn.setVisible(false);
			}
		}
	}
	
	public class t1Event implements ActionListener{
		public void actionPerformed(ActionEvent t1BtnEvent){
			if(check == 0) {
				agent0.startfloor = 2;
				check = 1;
				cBtn.setVisible(true);
				sBtn.setVisible(true);
				tBtn.setVisible(true);
				gBtn.setVisible(false);
				sfBtn.setVisible(false);
				t1Btn.setVisible(false);
				t2Btn.setVisible(false);
			}else if (check == 2){
				agent0.selectedfloor = 2;
			} else {
				agent0.selectedfloor = 2;
				rBtn.setVisible(true);
				gBtn.setVisible(false);
				sfBtn.setVisible(false);
				t1Btn.setVisible(false);
				t2Btn.setVisible(false);
			}
		}
	}
	
	public class t2Event implements ActionListener{
		public void actionPerformed(ActionEvent t2BtnEvent){
			if(check == 0) {
				agent0.startfloor = 3;
				check = 1;
				cBtn.setVisible(true);
				sBtn.setVisible(true);
				tBtn.setVisible(true);
				gBtn.setVisible(false);
				sfBtn.setVisible(false);
				t1Btn.setVisible(false);
				t2Btn.setVisible(false);
			}else if (check == 2){
				agent0.selectedfloor = 3;
			} else {
				agent0.selectedfloor = 3;
				rBtn.setVisible(true);
				gBtn.setVisible(false);
				sfBtn.setVisible(false);
				t1Btn.setVisible(false);
				t2Btn.setVisible(false);
			}
		}
	}
	
	public class cEvent implements ActionListener{
		public void actionPerformed(ActionEvent cBtnEvent){
			agent0.clearence = 1;
			gBtn.setVisible(true);
			sfBtn.setVisible(true);
			t1Btn.setVisible(true);
			t2Btn.setVisible(true);
			cBtn.setVisible(false);
			sBtn.setVisible(false);
			tBtn.setVisible(false);
		}
	}
	
	public class sEvent implements ActionListener{
		public void actionPerformed(ActionEvent sBtnEvent){
			agent0.clearence = 2;
			gBtn.setVisible(true);
			sfBtn.setVisible(true);
			t1Btn.setVisible(true);
			t2Btn.setVisible(true);
			cBtn.setVisible(false);
			sBtn.setVisible(false);
			tBtn.setVisible(false);
		}
	}
	
	public class tEvent implements ActionListener{
		public void actionPerformed(ActionEvent tBtnEvent){
			agent0.clearence = 3;
			gBtn.setVisible(true);
			sfBtn.setVisible(true);
			t1Btn.setVisible(true);
			t2Btn.setVisible(true);
			cBtn.setVisible(false);
			sBtn.setVisible(false);
			tBtn.setVisible(false);
		}
	}
	
	public class rEvent implements ActionListener{
		public void actionPerformed(ActionEvent rBtnEvent){
			Thread agent00 = new Thread(agent0);
				agent00.start();
				rBtn.setVisible(false);
		}
	}
	
	public void ElevatorPre(int agentnr, int startfloor) {
		addAgent(agentNum(agentnr), startfloor);
		agentsIn += 1;
		agentnumlabel.setText(agentsIn + "");
		sleep();
	}
	
	public void ElevatorEnter(int agentnr) {
		FloorLevel(elevator.start);
		agentEntered(agentNum(agentnr), elevator.start);
		enterExitlabel.setText("entered");
		sleep();
		ClearenceName();
		sleep();
		}
		
	public void ElevatorRun(int agent) {
		FloorLevel(elevator.floor);
		agentEntered(agentNum(elevator.agentNr), elevator.floor);
		sleep();
		if (!elevator.FloorCheck(elevator.level, elevator.floor)){
			 enterExitlabel.setText("no access");
			sleep();
			enterExitlabel.setText(" ");
		}else{
			enterExitlabel.setText("exit");
			sleep();
			agentExit(agentNum(elevator.agentNr), elevator.floor);
			sleep();
			enterExitlabel.setText(" ");
			clearencelabel.setText(" ");
			agentNum(elevator.agentNr).setVisible(false);
			agentsIn -= 1;
			agentnumlabel.setText(agentsIn + "");
			if (agent == 1) {
				agentcheck1 = 0;
			}else if (agent == 2) {
				agentcheck2 = 0;
			}else if (agent == 3) {
				agentcheck3 = 0;
			}
			elevator.inElevator = 0;
		}
	}
	
	public void AgentNewFloor() {
		check = 2;
		gBtn.setVisible(true);
		sfBtn.setVisible(true);
		t1Btn.setVisible(true);
		t2Btn.setVisible(true);
		
	}
		
	public void NewUserAgent() {
		check = 0;
		useragentlabel.setVisible(true);
		userAgentBtn.setVisible(true);
		gBtn.setVisible(false);
		sfBtn.setVisible(false);
		t1Btn.setVisible(false);
		t2Btn.setVisible(false);
	}
	
	public void FloorLevel(int floor) {
		Insets insets = Frame.getInsets();
		if (floor == 0){
			floorlabel.setText("Ground floor");
			elevatorPic.setBounds(226 + insets.left, 44 + insets.top, 119, 203);
		}else if (floor == 1){
			floorlabel.setText("Secret floor");
			elevatorPic.setBounds(226 + insets.left, 281 + insets.top, 119, 203);
		}else if (floor == 2){
			floorlabel.setText("Secret floor 2");
			elevatorPic.setBounds(226 + insets.left, 519 + insets.top, 119, 203);
		}else{
			floorlabel.setText("TOP-Secret floor");
			elevatorPic.setBounds(226 + insets.left, 755 + insets.top, 119, 203);
		}
	}
	
	public void ClearenceName()	{
		if (elevator.level == 1){
			clearencelabel.setText("Confidential");
		}else if (elevator.level == 2){
			clearencelabel.setText("Secret");
		}else{
			clearencelabel.setText("TOP-Secret");
		}
	}
	
	public JLabel agentNum(int agentnr) {
		if (agentnr == 0) {
			agent0Pic.setVisible(true);
			return agent0Pic;	
		}else if (agentnr == 1) {
			agent1Pic.setVisible(true);
			return agent1Pic;	
		}else if (agentnr == 2) {
			agent2Pic.setVisible(true);
			return agent2Pic;
		}else if (agentnr == 3) {
			agent3Pic.setVisible(true);
			return agent3Pic;	
		}else{	
			return null;
		}
	}
	
	public void addAgent(JLabel agent, int floors) {
		Insets insets = Frame.getInsets();
		if (floors == 0) {
			agent.setBounds(350 + insets.left, 44 + insets.top, 119, 203);
		}else if (floors == 1) {
			agent.setBounds(350 + insets.left, 281 + insets.top, 119, 203);
		}else if (floors == 2) {
			agent.setBounds(350 + insets.left, 519 + insets.top, 119, 203);
		}else if (floors == 3) {
			agent.setBounds(350 + insets.left, 755 + insets.top, 119, 203);
		}
	}
	
	public void agentEntered(JLabel agent, int floor) {
		Insets insets = Frame.getInsets();
		if (floor == 0){
			agent.setBounds(226 + insets.left, 44 + insets.top, 119, 203);
		}else if (floor == 1){
			agent.setBounds(226 + insets.left, 281 + insets.top, 119, 203);
		}else if (floor == 2){
			agent.setBounds(226 + insets.left, 519 + insets.top, 119, 203);
		}else{
			agent.setBounds(226 + insets.left, 755 + insets.top, 119, 203);
		}
	}
	
	public void agentExit(JLabel agent, int floors) {
		Insets insets = Frame.getInsets();
		if (floors == 0) {
			agent.setBounds(450 + insets.left, 44 + insets.top, 119, 203);
		}else if (floors == 1) {
			agent.setBounds(450 + insets.left, 281 + insets.top, 119, 203);
		}else if (floors == 2) {
			agent.setBounds(450 + insets.left, 519 + insets.top, 119, 203);
		}else if (floors == 3) {
			agent.setBounds(450 + insets.left, 755 + insets.top, 119, 203);
		}
	}
	
	public void sleep(){
		try {
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
