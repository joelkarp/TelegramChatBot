package TelegramBot.BotCommands;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class KinopolisKinoprogramm implements BotCommand{

	public String execute() {
		
		Document doc;
		try {
			doc = Jsoup.connect("https://www.kinopolis.de/bn/programm/woche-1").get();

			// System.out.println(links);
			Elements el = doc.getElementsByClass("kc_box_in");

			System.out.println(doc.title());

			String result = doc.title();
			
			for (int i = 0; i < 8; i++) {
				
				result += "\n" + el.get(i).child(0).text();
				result += "\n" + el.get(i).child(1).child(1).child(0).text();
				result += "\n" + el.get(i).child(0).child(0).attr("abs:href");
				result += "\n";
				
			}
			// System.out.println(el.get(0));

			return result;

		} catch (IOException e) {

			e.printStackTrace();

			return "Fehler in der Abfrage";
		}
	}
}


