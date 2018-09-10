package TelegramBot.BotCommands;

import java.io.IOException;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Wettervorhersage implements BotCommand {

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

		Document doc = Jsoup
				.connect("https://www.wetter.de/deutschland/wetter-bonn-18220678/wetterbericht-aktuell.html").get();
		return doc.getElementsByClass("column-content");

	}

	private String getWeatherForNextHoure(Elements elemnts) {

		String answer = "";
		Element curentElementWithTime;
		Element curentElementWithDetaildInfo;

		for (int i = 0; i < elemnts.size(); i++) {

			curentElementWithTime = elemnts.get(i).child(0);
			curentElementWithDetaildInfo = elemnts.get(i).child(1);

			if (getTimeFromNode(curentElementWithTime.text()).equals(getNextHour())) {

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

		String currentTime = df.format(now.getTime()).split(":")[0];

		if (currentTime.length() == 1)
			return "0" + currentTime;
		else
			return currentTime;

	}

	private String getNextHour() {

		String nextHour = (Integer.parseInt(getCurrentTimeHH()) + 1) + "";
		if (nextHour.length() == 1)
			return "0" + nextHour;
		else
			return nextHour;
	}

	private String getTimeFromNode(String text) {

		return text.split(" ")[0].split(":")[0];

	}

	private String getDataFromElement(Element node) {

		String data = "";

		data += node.child(0).text() + "\n";
		data += node.child(1).text() + "\n";

		return data;
	}

}
