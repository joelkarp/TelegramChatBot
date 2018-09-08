package TelegramBot.BotCommands;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class KinopolisKinoProgram implements BotCommand{

	public String execute() {
		
		Document doc;
		try {
			doc = Jsoup.connect("https://www.kinopolis.de/bn/programm/woche-1").get();

			// System.out.println(links);
			Elements el = doc.getElementsByClass("kc_box_in");

			System.out.println(doc.title());

			String ergebnis = doc.title();
			
			for (int i = 0; i < 8; i++) {
				
				ergebnis += "\n" + el.get(i).child(0).text();
				ergebnis += "\n" + el.get(i).child(1).child(1).child(0).text();
				ergebnis += "\n" + el.get(i).child(0).child(0).attr("abs:href");
				ergebnis += "\n";
				
			}
			// System.out.println(el.get(0));

			return ergebnis;

		} catch (IOException e) {

			e.printStackTrace();

			return "Fehler in der Abfrage";
		}
	}
}


