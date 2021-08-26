import java.io.IOException;

/* Controller class that handles both logic and GUI, Controller of MVC design pattern */
public class ArtemisController {
	private ArtemisModel theModel;
	private ArtemisView theView;
	
	/* Controller constructor takes in view and model to handle interaction */
	ArtemisController(ArtemisModel theModel, ArtemisView theView) throws IOException{
		this.theModel = theModel;
		this.theView = theView;
		/* Model attempts to scrape web data */
		theModel.scrapeData();
		/* View updates the GUI according to data retrieved */
		updatePanel();
	}
	
	/* Update the statistics panel that displays our scraped web data */
	public void updatePanel() {
		for(int i=0; i<20; i++) {
			theView.setRanksTextField(i, theModel.getRanksArrayElement(i));
			theView.setNamesTextField(i, theModel.getNamesArrayElement(i));
			theView.setPricesTextField(i, theModel.getPricesArrayElement(i));
			theView.setDailyPercentChangesTextField(i, theModel.getDailyPercentChangesArrayElement(i));
			theView.setWeeklyPercentChangesTextField(i, theModel.getWeeklyPercentChangesArrayElement(i));
			theView.setMarketCapsTextField(i, theModel.getMarketCapsArrayElement(i));
			theView.setDailyVolumesTextField(i, theModel.getDailyVolumesArrayElement(i));
		}
		updatePercentChangesBackgroundColor();
	}
	
	/* Updates the background color of daily & weekly percent changes to green or orange, depending on 
	 * positive or negative number */
	public void updatePercentChangesBackgroundColor() {
		for(int i=0; i<20; i++) {
			if(theModel.getDailyPercentChangesArrayElement(i).contains("-")) {
				/* Percentage value contains a negative sign */
				theView.setTextFieldBackgroundColor(theView.getDailyPercentChangesTextField(i), java.awt.Color.orange);
			}
			else {
				theView.setTextFieldBackgroundColor(theView.getDailyPercentChangesTextField(i), java.awt.Color.green);
			}
			
			if(theModel.getWeeklyPercentChangesArrayElement(i).contains("-")) {
				/* Percentage value contains a negative sign */
				theView.setTextFieldBackgroundColor(theView.getWeeklyPercentChangesTextField(i), java.awt.Color.orange);
			}
			else {
				theView.setTextFieldBackgroundColor(theView.getWeeklyPercentChangesTextField(i), java.awt.Color.green);
			}
		}
	}
}
