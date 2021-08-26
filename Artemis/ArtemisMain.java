import java.io.IOException;

public class ArtemisMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		/* Instantiate the model and the view, then the instantiate the controller every 1 minute
		 * which will update the data statistics panel */	
		ArtemisModel theModel = new ArtemisModel();
		ArtemisView theView = new ArtemisView();
		
		while(true) {
			ArtemisController theController = new ArtemisController(theModel, theView);
			Thread.sleep(60000);
		}	
	}
}
