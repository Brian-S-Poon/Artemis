import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/* Graphical User Interface Class, View of MVC design pattern */
public class ArtemisView extends JFrame{
	
	/* Create array of TextFields to populate Top 20 rank web data */
	private JTextField[] ranksTextField = new JTextField[20];
	private JTextField[] namesTextField = new JTextField[20];
	private JTextField[] pricesTextField = new JTextField[20];
	private JTextField[] dailyPercentChangesTextField = new JTextField[20];
	private JTextField[] weeklyPercentChangesTextField = new JTextField[20];
	private JTextField[] marketCapsTextField = new JTextField[20];
	private JTextField[] dailyVolumesTextField = new JTextField[20];
	
	/* This constructor will be called to instantiate the GUI component */
	ArtemisView() {
		
		/* Create two main JFrame Panels(label description panel and update panel),
		 * and seven sub panels for the update panel */
		JPanel labelDescriptionPanel = new JPanel();
		JPanel updatePanel = new JPanel();
		JPanel ranksTextFieldPanel = new JPanel();
		JPanel namesTextFieldPanel = new JPanel();
		JPanel pricesTextFieldPanel = new JPanel();
		JPanel dailyPercentChangesTextFieldPanel = new JPanel();
		JPanel weeklyPercentChangesTextFieldPanel = new JPanel();
		JPanel marketCapsTextFieldPanel = new JPanel();
		JPanel dailyVolumesTextFieldPanel = new JPanel();
		
		/* Set all panel background colors to black */
		labelDescriptionPanel.setBackground(Color.black);
		updatePanel.setBackground(Color.black);
		ranksTextFieldPanel.setBackground(Color.black);
		namesTextFieldPanel.setBackground(Color.black);
		pricesTextFieldPanel.setBackground(Color.black);
		dailyPercentChangesTextFieldPanel.setBackground(Color.black);
		weeklyPercentChangesTextFieldPanel.setBackground(Color.black);
		marketCapsTextFieldPanel.setBackground(Color.black);
		dailyVolumesTextFieldPanel.setBackground(Color.black);
		
		/* Set preferred dimensions for panels, however will layout manager frame.pack */
		labelDescriptionPanel.setPreferredSize(new Dimension(1500,50));
		updatePanel.setPreferredSize(new Dimension(1500,750));
		ranksTextFieldPanel.setPreferredSize(new Dimension(200,750));
		namesTextFieldPanel.setPreferredSize(new Dimension(200,750));
		pricesTextFieldPanel.setPreferredSize(new Dimension(200,750));
		dailyPercentChangesTextFieldPanel.setPreferredSize(new Dimension(200,750));
		weeklyPercentChangesTextFieldPanel.setPreferredSize(new Dimension(200,750));
		marketCapsTextFieldPanel.setPreferredSize(new Dimension(200,750));
		dailyVolumesTextFieldPanel.setPreferredSize(new Dimension(200,750));
		
		/* Set desired grid layouts for panels */
		labelDescriptionPanel.setLayout(new GridLayout(1,7));
		updatePanel.setLayout(new GridLayout(1,7));
		ranksTextFieldPanel.setLayout(new GridLayout(0,1));
		namesTextFieldPanel.setLayout(new GridLayout(0,1));
		pricesTextFieldPanel.setLayout(new GridLayout(0,1));
		dailyPercentChangesTextFieldPanel.setLayout(new GridLayout(0,1));
		weeklyPercentChangesTextFieldPanel.setLayout(new GridLayout(0,1));
		marketCapsTextFieldPanel.setLayout(new GridLayout(0,1));
		dailyVolumesTextFieldPanel.setLayout(new GridLayout(0,1));
		
		/* Instantiate & format Text Fields, then add to label descriptions panel (Top panel 1x7 labels) */
		String[] labelDescriptions = {"Rank","Name","Current Price","24h %","7d %","Market Cap","Volume(24h)"};
		JTextField[] labelDescriptionsTextField = new JTextField[labelDescriptions.length];	
		for(int i=0; i<labelDescriptionsTextField.length; i++) {
			labelDescriptionsTextField[i] = new JTextField();
			labelDescriptionsTextField[i].setText(labelDescriptions[i]);
			labelDescriptionsTextField[i].setPreferredSize(new Dimension(100,25));
			labelDescriptionsTextField[i].setEditable(false);
			labelDescriptionsTextField[i].setFont(new Font("Monaco",Font.BOLD,20));
			labelDescriptionsTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelDescriptionsTextField[i].setBackground(Color.black);
			labelDescriptionsTextField[i].setForeground(Color.white);
			labelDescriptionPanel.add(labelDescriptionsTextField[i]);
		}
		
		/* Instantiate & format Text Fields, then add to ranks panel*/
		for(int i=0; i<ranksTextField.length; i++) {
			ranksTextField[i] = new JTextField("Loading...");
			ranksTextField[i].setPreferredSize(new Dimension(100,25));
			ranksTextField[i].setEditable(false);
			ranksTextField[i].setFont(new Font("Consolas",Font.BOLD,14));
			ranksTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
			ranksTextField[i].setBackground(Color.black);
			ranksTextField[i].setForeground(Color.white);	
			ranksTextFieldPanel.add(ranksTextField[i]);
		}
		
		/* Instantiate & format Text Fields, then add to names panel*/
		for(int i=0; i<namesTextField.length; i++) {
			namesTextField[i] = new JTextField("Loading...");
			namesTextField[i].setPreferredSize(new Dimension(100,25));
			namesTextField[i].setEditable(false);
			namesTextField[i].setFont(new Font("Monaco",Font.BOLD,12));
			namesTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
			namesTextField[i].setBackground(Color.black);
			namesTextField[i].setForeground(Color.white);
			namesTextFieldPanel.add(namesTextField[i]);
		}
		
		/* Instantiate & format Text Fields, then add to prices panel*/
		for(int i=0; i<pricesTextField.length; i++) {
			pricesTextField[i] = new JTextField("Loading...");
			pricesTextField[i].setPreferredSize(new Dimension(100,25));
			pricesTextField[i].setEditable(false);
			pricesTextField[i].setFont(new Font("Monaco",Font.BOLD,14));
			pricesTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
			pricesTextField[i].setBackground(Color.black);
			pricesTextField[i].setForeground(Color.green);
			pricesTextFieldPanel.add(pricesTextField[i]);	
		}
		
		/* Instantiate & format Text Fields, then add to daily percent changes panel*/
		for(int i=0; i<dailyPercentChangesTextField.length; i++) {
			dailyPercentChangesTextField[i] = new JTextField("Loading...");
			dailyPercentChangesTextField[i].setPreferredSize(new Dimension(100,25));
			dailyPercentChangesTextField[i].setEditable(false);
			dailyPercentChangesTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
			dailyPercentChangesTextField[i].setFont(new Font("Consolas",Font.BOLD,14));
			dailyPercentChangesTextField[i].setBackground(Color.black);
			dailyPercentChangesTextFieldPanel.add(dailyPercentChangesTextField[i]);	
		}
		
		/* Instantiate & format Text Fields, then add to weekly percent changes panel*/
		for(int i=0; i<weeklyPercentChangesTextField.length; i++) {
			weeklyPercentChangesTextField[i] = new JTextField("Loading...");
			weeklyPercentChangesTextField[i].setPreferredSize(new Dimension(100,25));
			weeklyPercentChangesTextField[i].setEditable(false);
			weeklyPercentChangesTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
			weeklyPercentChangesTextField[i].setBackground(Color.black);
			weeklyPercentChangesTextField[i].setFont(new Font("Consolas",Font.BOLD,14));
			weeklyPercentChangesTextFieldPanel.add(weeklyPercentChangesTextField[i]);	
		}
		
		/* Instantiate & format Text Fields, then add to market caps panel*/
		for(int i=0; i<marketCapsTextField.length; i++) {
			marketCapsTextField[i] = new JTextField("Loading...");
			marketCapsTextField[i].setPreferredSize(new Dimension(100,25));
			marketCapsTextField[i].setEditable(false);
			marketCapsTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
			marketCapsTextField[i].setFont(new Font("Monaco",Font.BOLD,12));
			marketCapsTextField[i].setBackground(Color.black);
			marketCapsTextField[i].setForeground(Color.green);
			marketCapsTextFieldPanel.add(marketCapsTextField[i]);	
		}
		
		/* Instantiate & format Text Fields, then add to daily volumes panel*/
		for(int i=0; i<dailyVolumesTextField.length; i++) {
			dailyVolumesTextField[i] = new JTextField("Loading...");
			dailyVolumesTextField[i].setPreferredSize(new Dimension(100,25));
			dailyVolumesTextField[i].setEditable(false);
			dailyVolumesTextField[i].setHorizontalAlignment(SwingConstants.CENTER);
			dailyVolumesTextField[i].setFont(new Font("Monaco",Font.BOLD,12));
			dailyVolumesTextField[i].setBackground(Color.black);
			dailyVolumesTextField[i].setForeground(Color.green);
			dailyVolumesTextFieldPanel.add(dailyVolumesTextField[i]);	
		}
		
		/* Add all text field panels to update panel in corresponding order */
		updatePanel.add(ranksTextFieldPanel);
		updatePanel.add(namesTextFieldPanel);
		updatePanel.add(pricesTextFieldPanel);
		updatePanel.add(dailyPercentChangesTextFieldPanel);
		updatePanel.add(weeklyPercentChangesTextFieldPanel);
		updatePanel.add(marketCapsTextFieldPanel);
		updatePanel.add(dailyVolumesTextFieldPanel);
		
		/* Instantiate application logo from .png located in Java project folder */
		ImageIcon logo = new ImageIcon("Artemis_Logo.png");
		/* Instantiate our JFrame and format layout, close, title, and size preferences */
		JFrame frame = new JFrame();
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Artemis");
		this.setPreferredSize(new Dimension(1000,800));;
		this.setIconImage(logo.getImage());
		/* Add label descriptions panel and update panel to the JFrame */
		this.add(labelDescriptionPanel,BorderLayout.NORTH);
		this.add(updatePanel,BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();	
	}
	
	public void setRanksTextField(int index, String text) {
		ranksTextField[index].setText(text);
	}
	
	public void setNamesTextField(int index, String text) {
		namesTextField[index].setText(text);
	}
	
	public void setPricesTextField(int index, String text) {
		pricesTextField[index].setText(text);
	}
	
	public void setDailyPercentChangesTextField(int index, String text) {
		dailyPercentChangesTextField[index].setText(text);
	}
	
	public void setWeeklyPercentChangesTextField(int index, String text) {
		weeklyPercentChangesTextField[index].setText(text);
	}
	
	public void setMarketCapsTextField(int index, String text) {
		marketCapsTextField[index].setText(text);
	}
	
	public void setDailyVolumesTextField(int index, String text) {
		dailyVolumesTextField[index].setText(text);
	}
	
	public void setTextFieldBackgroundColor(JTextField textField, Color color) {
		textField.setBackground(color);
	}
	
	public JTextField getDailyPercentChangesTextField(int index) {
		return dailyPercentChangesTextField[index];
	}
	
	public JTextField getWeeklyPercentChangesTextField(int index) {
		return weeklyPercentChangesTextField[index];
	}
}
