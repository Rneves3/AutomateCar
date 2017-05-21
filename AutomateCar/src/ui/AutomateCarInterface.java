package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.util.*;
import jess.*;


	public class AutomateCarInterface {

		private JFrame frame;
		
		//environment variables
		public static float temperature;
		public static float time;
		public static float velocity;
		public static float fuel;
		public static float dist;
		public static float oxigen;
		public static String weather;

		//car variables
		private boolean hotAir = false;
		private boolean coldAir = false;
		
		private boolean openWindows = false;
		private boolean closeWindows = false;
		
		private boolean lightsOn = false;
		private boolean lightsOff = false;
		
		boolean exited = false;
		
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			
			System.out.print("Hey there! Welcome to the smart car!" +
					" Please tell me how is the weather today! " +
					"\nIs it Sunny or Cloudy?\n");
			Scanner in = new Scanner(System.in);
			weather = in.next();
			
			System.out.print("Testing temperaute :\n");
			temperature = in.nextInt();
			
			System.out.print("Testing time :\n");
			time = in.nextInt();
			
			System.out.print("Testing velocity :\n");
			velocity = in.nextInt();
			
			System.out.print("Testing fuel :\n");
			fuel = in.nextInt();
			
			System.out.print("Testing distance :\n");
			dist = in.nextInt();
			
			System.out.print("Testing oxigen levels :\n");
			oxigen = in.nextInt();
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AutomateCarInterface window = new AutomateCarInterface();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public AutomateCarInterface() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			
			try{
				
	        Rete engine = new Rete();
			engine.batch("teste.clp");
			
			engine.eval("(deftemplate temperature (slot celsius))");
			Fact f = new Fact("temperature", engine);
			f.setSlotValue("celsius", new Value(temperature, RU.FLOAT));
			engine.assertFact(f);
			
			engine.eval("(deftemplate time (slot hours))");
			Fact t = new Fact("time", engine);
			t.setSlotValue("hours", new Value(time, RU.FLOAT));
			engine.assertFact(t);
			
			engine.eval("(deftemplate velocity (slot kmh))");
			Fact v = new Fact("velocity", engine);
			v.setSlotValue("kmh", new Value(velocity, RU.FLOAT));
			engine.assertFact(v);
			
			engine.eval("(deftemplate fuel (slot litres))");
			Fact g = new Fact("fuel", engine);
			g.setSlotValue("litres", new Value(fuel, RU.FLOAT));
			engine.assertFact(g);
			
			engine.eval("(deftemplate oxigen (slot cubic))");
			Fact o = new Fact("oxigen", engine);
			o.setSlotValue("cubic", new Value(oxigen, RU.FLOAT));
			engine.assertFact(o);
			
			engine.eval("(deftemplate distance (slot maxDist))");
			Fact d = new Fact("distance", engine);
			d.setSlotValue("maxDist", new Value(dist, RU.FLOAT));
			engine.assertFact(d);
			
			Fact w = new Fact(""+ weather, engine);
			engine.assertFact(w);
			
			//engine.eval("(facts)");
			//engine.eval("parameters ("+ temperature1 + " " + time + " " + velocity + " " + fuel + " " + oxigen + " " + 2 + ")");
			engine.run();
			
			}
			catch(JessException je){
				je.printStackTrace();
			}
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTemperature = new JLabel("Temperature (\u00BAC)");
		lblTemperature.setBounds(28, 108, 119, 26);
		frame.getContentPane().add(lblTemperature);
		
		JLabel lblTime = new JLabel("Time (h)");
		lblTime.setBounds(28, 167, 119, 14);
		frame.getContentPane().add(lblTime);
		
		JLabel lblVelocity = new JLabel("Velocity (km/h)");
		lblVelocity.setBounds(28, 218, 119, 14);
		frame.getContentPane().add(lblVelocity);
		
		JLabel lblFuel = new JLabel("Fuel (l)");
		lblFuel.setBounds(28, 276, 119, 14);
		frame.getContentPane().add(lblFuel);
		
		JLabel lblPassengerWeight = new JLabel("Distance (m)");
		lblPassengerWeight.setBounds(28, 326, 119, 14);
		frame.getContentPane().add(lblPassengerWeight);
		
		JLabel lblOxigen = new JLabel("Oxigen");
		lblOxigen.setBounds(28, 385, 119, 14);
		frame.getContentPane().add(lblOxigen);
		
		JLabel lblVariables = new JLabel("Variables");
		lblVariables.setBounds(28, 47, 119, 14);
		frame.getContentPane().add(lblVariables);
		
		JLabel lblValues = new JLabel("Values");
		lblValues.setBounds(157, 47, 112, 14);
		frame.getContentPane().add(lblValues);
		
		JLabel lblControls = new JLabel("Controls");
		lblControls.setBounds(279, 47, 124, 14);
		frame.getContentPane().add(lblControls);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(413, 47, 271, 14);
		frame.getContentPane().add(lblMessage);
		
		final JLabel tempValLabel = new JLabel("0");
		tempValLabel.setBounds(174, 114, 97, 14);
		frame.getContentPane().add(tempValLabel);
		
		final JLabel timeValLabel = new JLabel("0");
		timeValLabel.setBounds(174, 167, 95, 14);
		frame.getContentPane().add(timeValLabel);
		
		final JLabel velValLabel = new JLabel("0");
		velValLabel.setBounds(174, 218, 95, 14);
		frame.getContentPane().add(velValLabel);
		
		final JLabel fuelValLabel = new JLabel("0");
		fuelValLabel.setBounds(174, 276, 97, 14);
		frame.getContentPane().add(fuelValLabel);
		
		final JLabel weightValLabel = new JLabel("0");
		weightValLabel.setBounds(174, 326, 95, 14);
		frame.getContentPane().add(weightValLabel);
		
		final JLabel oxigenValLabel = new JLabel("0");
		oxigenValLabel.setBounds(174, 385, 95, 14);
		frame.getContentPane().add(oxigenValLabel);
		
		JLabel tempMsgLabel = new JLabel("Nothing to show.");
		tempMsgLabel.setBounds(413, 114, 271, 14);
		frame.getContentPane().add(tempMsgLabel);
		
		JLabel timeMsgLabel = new JLabel("Nothing to show.");
		timeMsgLabel.setBounds(413, 167, 271, 14);
		frame.getContentPane().add(timeMsgLabel);
		
		JLabel velMsgLabel = new JLabel("Nothing to show.");
		velMsgLabel.setBounds(413, 218, 271, 14);
		frame.getContentPane().add(velMsgLabel);
		
		JLabel fuelMsgLabel = new JLabel("Nothing to show.");
		fuelMsgLabel.setBounds(413, 276, 271, 14);
		frame.getContentPane().add(fuelMsgLabel);
		
		JLabel weightMsgLabel = new JLabel("Nothing to show.");
		weightMsgLabel.setBounds(413, 326, 271, 14);
		frame.getContentPane().add(weightMsgLabel);
		
		JLabel oxigenMsgLabel = new JLabel("Nothing to show.");
		oxigenMsgLabel.setBounds(413, 385, 271, 14);
		frame.getContentPane().add(oxigenMsgLabel);
		
		/*JLabel exitLabel = new JLabel("Nothing to show.");
		exitLabel.setBounds(413, 475, 271, 14);
		frame.getContentPane().add(exitLabel);*/
		
//BUTTONS
		JButton tempIncButton = new JButton("+");
		tempIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(temperature >= 100){
					tempValLabel.setText("" + temperature);
					return;
				}
				temperature++;
				updateTemp();
				controlTemp();
				tempValLabel.setText("" + temperature);
			}
		});
		tempIncButton.setBounds(279, 110, 46, 23);
		frame.getContentPane().add(tempIncButton);
		
		JButton tempDecButton = new JButton("-");
		tempDecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(temperature <= -60){
					tempValLabel.setText("" + temperature);
					return;
				}
				temperature--;
				updateTemp();
				controlTemp();
				tempValLabel.setText("" + temperature);
			}
		});
		tempDecButton.setBounds(346, 110, 46, 23);
		frame.getContentPane().add(tempDecButton);
		
		JButton timeIncButton = new JButton("+");
		timeIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(time >= 24){
					time = 0;
					timeValLabel.setText("" + time);
					return;
				}
				time++;
				updateTime();
				timeValLabel.setText("" + time);
			}
		});
		timeIncButton.setBounds(279, 163, 46, 23);
		frame.getContentPane().add(timeIncButton);
		
		JButton timeDecButton = new JButton("-");
		timeDecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(time <= 0){
					time = 24;
					timeValLabel.setText("" + time);
					return;
				}
				time--;
				updateTime();
				timeValLabel.setText("" + time);
			}
		});
		timeDecButton.setBounds(346, 163, 46, 23);
		frame.getContentPane().add(timeDecButton);
		
		JButton velIncButton = new JButton("+");
		velIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(velocity >= 400){
					velocity = 0;
					velValLabel.setText("" + velocity);
					return;
				}
				velocity++;
				updateVelocity();
				controlVelocity();
				velValLabel.setText("" + velocity);
			}
		});
		velIncButton.setBounds(279, 214, 46, 23);
		frame.getContentPane().add(velIncButton);
		
		JButton velDecButton = new JButton("-");
		velDecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(velocity <= 0){
					velValLabel.setText("" + velocity);
					return;
				}
				velocity--;
				updateVelocity();
				controlVelocity();
				velValLabel.setText("" + velocity);
			}
		});
		velDecButton.setBounds(346, 214, 46, 23);
		frame.getContentPane().add(velDecButton);
		
		JButton fuelIncButton = new JButton("+");
		fuelIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(fuel >= 60){
					fuelValLabel.setText("" + fuel);
					return;
				}
				fuel++;
				updateFuel();
				fuelValLabel.setText("" + fuel);
			}
		});
		fuelIncButton.setBounds(279, 272, 46, 23);
		frame.getContentPane().add(fuelIncButton);
		

		JButton fuelDecButton = new JButton("-");
		fuelDecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(fuel <= 0){
					fuelValLabel.setText("" + fuel);
					return;
				}
				fuel--;
				updateFuel();
				fuelValLabel.setText("" + fuel);
			}
		});
		fuelDecButton.setBounds(346, 272, 46, 23);
		frame.getContentPane().add(fuelDecButton);
		
		JButton weightIncButton = new JButton("+");
		weightIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(dist >= 400){
					weightValLabel.setText("" + dist);
					return;
				}
				dist++;
				updateDist();
				weightValLabel.setText("" + dist);
			}
		});		
		weightIncButton.setBounds(279, 322, 46, 23);
		frame.getContentPane().add(weightIncButton);
		
		
		JButton weightDecButton = new JButton("-");
		fuelIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(dist <= 0){
					weightValLabel.setText("" + dist);
					return;
				}
				dist--;
				updateDist();
				weightValLabel.setText("" + dist);
			}
		});
		weightDecButton.setBounds(346, 322, 46, 23);
		frame.getContentPane().add(weightDecButton);
		
		
		JButton oxigenIncButton = new JButton("+");
		oxigenIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				oxigenValLabel.setText("" + oxigen);
				oxigen++;
				updateOxigen();
				controlOxigen();
				return;
			}
				
		});
		oxigenIncButton.setBounds(279, 376, 46, 23);
		frame.getContentPane().add(oxigenIncButton);
		
		
		JButton oxigenDecButton = new JButton("-");
		oxigenDecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				oxigenValLabel.setText("" + oxigen);
				updateOxigen();
				controlOxigen();
				return;
			}
		});
		oxigenDecButton.setBounds(346, 376, 46, 23);
		frame.getContentPane().add(oxigenDecButton);
	
		JButton exitBtn = new JButton("exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				exited = true;
				//exitLabel.setText("");
				if(exited == true)
					System.exit(0);
					return;
			}
		
		});
		exitBtn.setBounds(300, 475, 60, 35);
		frame.getContentPane().add(exitBtn);
		
		
		}
		private void updateTemp() {
			
			try{
				
	        Rete engine = new Rete();
			engine.batch("teste.clp");
			
			engine.eval("(deftemplate temperature (slot celsius))");
			Fact f = new Fact("temperature", engine);
			f.setSlotValue("celsius", new Value(temperature, RU.FLOAT));
			engine.assertFact(f);
			
			engine.run();
			}
			catch(JessException je){
				je.printStackTrace();
			}}

	private void updateTime() {
		
		try{
			
	    Rete engine = new Rete();
		engine.batch("teste.clp");
		
		engine.eval("(deftemplate time (slot hours))");
		Fact t = new Fact("time", engine);
		t.setSlotValue("hours", new Value(time, RU.FLOAT));
		engine.assertFact(t);
		
		Fact w = new Fact(""+ weather, engine);
		engine.assertFact(w);
		
		engine.run();
		}
		catch(JessException je){
			je.printStackTrace();
		}}

	private void updateVelocity() {
		
		try{
			
	    Rete engine = new Rete();
		engine.batch("teste.clp");
		
		engine.eval("(deftemplate velocity (slot kmh))");
		Fact v = new Fact("velocity", engine);
		v.setSlotValue("kmh", new Value(velocity, RU.FLOAT));
		engine.assertFact(v);

		engine.run();
		}
		catch(JessException je){
			je.printStackTrace();
		}}

	private void updateFuel() {
		
		try{
			
	    Rete engine = new Rete();
		engine.batch("teste.clp");

		engine.eval("(deftemplate fuel (slot litres))");
		Fact g = new Fact("fuel", engine);
		g.setSlotValue("litres", new Value(fuel, RU.FLOAT));
		engine.assertFact(g);
		
		engine.run();
		}
		catch(JessException je){
			je.printStackTrace();
		}}

	private void updateOxigen() {
		
		try{
			
	    Rete engine = new Rete();
		engine.batch("teste.clp");
		
		engine.eval("(deftemplate oxigen (slot cubic))");
		Fact o = new Fact("oxigen", engine);
		o.setSlotValue("cubic", new Value(oxigen, RU.FLOAT));
		engine.assertFact(o);
		
		engine.run();
		}
		catch(JessException je){
			je.printStackTrace();
		}}


	private void updateDist() {
		
		try{	
			
		Rete engine = new Rete();
		engine.batch("teste.clp");
		
		engine.eval("(deftemplate distance (slot maxDist))");
		Fact d = new Fact("distance", engine);
		d.setSlotValue("maxDist", new Value(dist, RU.FLOAT));
		engine.assertFact(d);
		
		engine.run();
		}
		catch(JessException je){
			je.printStackTrace();
		}	}


	public void controlVelocity(){
		
		if(velocity > 150){
			System.out.print("\n Car is slowing down\n");
			Thread.sleep(2000);
			velocity = 120;
		}
	}

	public void controlOxigen(){
		
		if(oxigen < 21){
			System.out.print("\n Temperature levels increasing\n");
			oxigen = 21;
		}
	}
	
	public void controlTemp(){
		
		if(temperature > 25){
			System.out.print("\n Too hot! Settling temperature!\n");
			Thread.sleep(2000);
			temperature = 24;
		}
		
		if(temperature < 15){
			System.out.print("\n Too cold! Settling temperature!\n");
			Thread.sleep(2000);
			temperature = 0;
		}
	}
}