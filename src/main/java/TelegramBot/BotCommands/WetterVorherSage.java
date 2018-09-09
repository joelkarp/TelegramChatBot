package TelegramBot.BotCommands;

import java.io.IOException;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WetterVorherSage implements BotCommand {

	public String execute() {

		try {
			Elements elemnts = getWebsiteElements();
			return getWeatherForNextHoure(elemnts);

		} catch (IOException e) {

			e.printStackTrace();
			return "Fehler in der Abfrage";
		}
	}

	private Elements getWebsiteElements() throws IOException {
		Document doc;
		
		doc = Jsoup.connect("https://www.wetter.de/deutschland/wetter-bonn-18220678/wetterbericht-aktuell.html").get();
		Elements elemnts = doc.getElementsByClass("column-content");
		
		return elemnts;
	}

	private String getWeatherForNextHoure(Elements elemnts) {

		String answer = "";
		Element curentElementWithTime;
		Element curentElementWithDetaildInfo;

		for (int i = 0; i < elemnts.size(); i++) {

			curentElementWithTime = elemnts.get(i).child(0);
			curentElementWithDetaildInfo = elemnts.get(i).child(1);

			if (getTimeFromNode(curentElementWithTime.text()).equals(getNextHoure())) {

				answer += getDataFromElement(curentElementWithTime);
				answer += getDataFromElement(curentElementWithDetaildInfo);
			}
		}
		return answer;

	}

	private String getCurrentTimeHH() {

		GregorianCalendar now = new GregorianCalendar();
		DateFormat df;
		df = DateFormat.getTimeInstance(DateFormat.SHORT);
		return df.format(now.getTime()).split(":")[0];

	}

	private String getNextHoure() {
		return (Integer.parseInt(getCurrentTimeHH()) + 1) + "";
	}

	private String getTimeFromNode(String text) {

		return text.split(" ")[0].split(":")[0];

	}

	private String getDataFromElement(Element node) {

		String ergebnis = "";

		ergebnis += node.child(0).text() + "\n";
		ergebnis += node.child(1).text() + "\n";

		return ergebnis;
	}


}
