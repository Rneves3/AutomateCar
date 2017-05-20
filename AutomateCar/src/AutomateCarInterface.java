import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import jess.*;


public class AutomateCarInterface {

	private JFrame frame;
	
	//enrionment variables
	private float temperature 	 = 0;
	private float time 			 = 0;
	private float velocity 		 = 0;
	private float fuel 			 = 0;
	private float passengerWeight = 0;
	private float oxigen 		 = 0;

	//car variables
	private boolean hotAir = false;
	private boolean coldAir = false;
	
	private boolean openWindows = false;
	private boolean closeWindows = false;
	
	private boolean airbag = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		//engine.eval("(main)");
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
		
		JLabel lblPassengerWeight = new JLabel("Passenger Weight (kg)");
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
		
//BUTTONS
		JButton tempIncButton = new JButton("+");
		tempIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(temperature >= 100){
					tempValLabel.setText("" + temperature);
					return;
				}
				temperature++;
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
				fuelValLabel.setText("" + fuel);
			}
		});
		fuelDecButton.setBounds(346, 272, 46, 23);
		frame.getContentPane().add(fuelDecButton);
		
		JButton weightIncButton = new JButton("+");
		weightIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(passengerWeight >= 400){
					weightValLabel.setText("" + passengerWeight);
					return;
				}
				passengerWeight++;
				weightValLabel.setText("" + passengerWeight);
			}
		});
		weightIncButton.setBounds(279, 322, 46, 23);
		frame.getContentPane().add(weightIncButton);
		
		
		JButton weightDecButton = new JButton("-");
		fuelIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(passengerWeight <= 0){
					weightValLabel.setText("" + passengerWeight);
					return;
				}
				passengerWeight++;
				weightValLabel.setText("" + passengerWeight);
			}
		});
		weightDecButton.setBounds(346, 322, 46, 23);
		frame.getContentPane().add(weightDecButton);
		
		
		JButton oxigenIncButton = new JButton("+");
		oxigenIncButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				oxigenValLabel.setText("" + oxigen);
				return;
			}
		});
		oxigenIncButton.setBounds(279, 376, 46, 23);
		frame.getContentPane().add(oxigenIncButton);
		
		
		JButton oxigenDecButton = new JButton("-");
		oxigenDecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				oxigenValLabel.setText("" + oxigen);
				return;
			}
		});
		oxigenDecButton.setBounds(346, 376, 46, 23);
		frame.getContentPane().add(oxigenDecButton);
//-----
		
	}
}
