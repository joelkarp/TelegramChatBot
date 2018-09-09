package TelegramBot.BotCommands;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WetterVorherSage implements BotCommand{

public String execute() {
		
		Document doc;
		try {
			doc = Jsoup.connect("https://www.wetter.de/deutschland/wetter-bonn-18220678/wetterbericht-aktuell.html").get();


			Elements elemnts = doc.getElementsByClass("column-content");

			System.out.println(doc.title());

			String ergebnis = doc.title();
			


			return ergebnis;

		} catch (IOException e) {

			e.printStackTrace();

			return "Fehler in der Abfrage";
		}
	}
	
}
