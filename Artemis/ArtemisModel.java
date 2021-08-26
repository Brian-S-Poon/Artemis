import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* Business logic class, Model of MVC design pattern */
public class ArtemisModel {
	
	/* Target website URL to scrape data */
	private final String url = "https://coinmarketcap.com/all/views/all/";
	
	/* Initialize global arrays */
	private String[] ranksArray = new String[20];
	private String[] namesArray = new String[20];
	private String[] pricesArray = new String[20];
	private String[] dailyPercentChangesArray = new String[20];
	private String[] weeklyPercentChangesArray = new String[20];
	private String[] marketCapsArray = new String[20];
	private String[] dailyVolumesArray = new String[20];
	
	/* This method attempts to scrape web data and populate corresponding arrays */
	public void scrapeData() throws IOException {
		
		/* Attempt connect to website */
		final Document document = Jsoup.connect(url).get();
		
		/* Initialize temporary ArrayList */
		List<String> ranksList = new ArrayList<String>();
		List<String> namesList = new ArrayList<String>();
		List<String> pricesList = new ArrayList<String>();
		List<String> dailyPercentChangesList = new ArrayList<String>();
		List<String> weeklyPercentChangesList = new ArrayList<String>();
		List<String> marketCapsList = new ArrayList<String>();
		List<String> dailyVolumesList = new ArrayList<String>();
			
		/* Populate ArrayLists with corresponding HTML elements */
		// Add ranks to ArrayList
		Elements currencyRanks = document.select("td.cmc-table__cell.cmc-table__cell--sticky.cmc-table__cell--sortable.cmc-table__cell--left.cmc-table__cell--sort-by__rank\r\n" + 
				"");	
		for(Element element : currencyRanks) {
			ranksList.add(element.text());
		}
		// Add names to ArrayList
		Elements currencyNames = document.select("td.cmc-table__cell.cmc-table__cell--sticky.cmc-table__cell--sortable.cmc-table__cell--left.cmc-table__cell--sort-by__name\r\n" + 
				"");
		for(Element element : currencyNames) {
			namesList.add(element.getElementsByTag("a").text());
		}
		// Add prices to ArrayList
		Elements currencyPrices = document.select("td.cmc-table__cell.cmc-table__cell--sortable.cmc-table__cell--right.cmc-table__cell--sort-by__price\r\n" + 
				"");
		for(Element element : currencyPrices) {
			pricesList.add(element.text());
		}
		// Add daily percent changes to ArrayList
		Elements currencyDailyPercentChange = document.select("td.cmc-table__cell.cmc-table__cell--sortable.cmc-table__cell--right.cmc-table__cell--sort-by__percent-change-24-h\r\n" + 
				"");
		for(Element element : currencyDailyPercentChange) {
			dailyPercentChangesList.add(element.text());
		}
		// Add weekly percent changes to ArrayList
		Elements currencyWeeklyPercentChange = document.select("td.cmc-table__cell.cmc-table__cell--sortable.cmc-table__cell--right.cmc-table__cell--sort-by__percent-change-7-d\r\n" + 
				"");
		for(Element element : currencyWeeklyPercentChange) {
			weeklyPercentChangesList.add(element.text());
		}
		// Add market caps to ArrayList
		Elements marketCaps = document.select("td.cmc-table__cell--sort-by__market-cap.cmc-table__cell--right.cmc-table__cell--sortable.cmc-table__cell\r\n" + 
				"");
		for(Element element : marketCaps) {
			marketCapsList.add(element.text());
		}
		// Add daily volumes to ArrayList
		Elements dailyVolumes = document.select("td.cmc-table__cell--sort-by__volume-24-h.cmc-table__cell--right.cmc-table__cell--sortable.cmc-table__cell\r\n" + 
				"");
		for(Element element : dailyVolumes) {
			dailyVolumesList.add(element.text());
		}
		
		/* Populate global arrays using corresponding ArrayLists */
		ranksList.toArray(ranksArray);
		namesList.toArray(namesArray);
		pricesList.toArray(pricesArray);
		dailyPercentChangesList.toArray(dailyPercentChangesArray);
		weeklyPercentChangesList.toArray(weeklyPercentChangesArray);
		marketCapsList.toArray(marketCapsArray);
		dailyVolumesList.toArray(dailyVolumesArray);
		
		/* For loop to call formatMarketCaps function and format market caps text */
		for(int i=0; i<marketCapsArray.length; i++) {
			if(marketCapsArray[i]!=null) {
				marketCapsArray[i] = formatMarketCaps(marketCapsArray[i]);
			}
		}
	}
	
	/* Function to properly format market caps text */
	public String formatMarketCaps(String text) {
		boolean letterFound = false;
		StringBuilder StringBuilder = new StringBuilder();
		char[] charArray = text.toCharArray();
		
		for(char c : charArray) {
			if(letterFound) {
				StringBuilder.append(c);
			}
			if(c=='B') {
				letterFound = true;
			}
		}
		return StringBuilder.toString();
	}
	
	public String getRanksArrayElement(int index) {
		return ranksArray[index];
	}
	
	public String getNamesArrayElement(int index) {
		return namesArray[index];
	}
	
	public String getPricesArrayElement(int index) {
		return pricesArray[index];
	}
	
	public String getDailyPercentChangesArrayElement(int index) {
		return dailyPercentChangesArray[index];
	}
	
	public String getWeeklyPercentChangesArrayElement(int index) {
		return weeklyPercentChangesArray[index];
	}
	
	public String getMarketCapsArrayElement(int index) {
		return marketCapsArray[index];
	}
	
	public String getDailyVolumesArrayElement(int index) {
		return dailyVolumesArray[index];
	}
}
