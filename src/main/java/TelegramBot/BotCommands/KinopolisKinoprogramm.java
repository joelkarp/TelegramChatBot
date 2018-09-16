package TelegramBot.BotCommands;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import TelegramBot.TelegramChatBot.TelegramBot;

public class KinopolisKinoprogramm implements BotCommand{

	public String execute() {
		
		Document doc;
		try {
			doc = Jsoup.connect("https://www.kinopolis.de/bn/programm/woche-1").get();
			Elements el = doc.getElementsByClass("kc_box_in");
			String result = doc.title();
			
			for (int i = 0; i < 8; i++) {	
				result += "\n" + el.get(i).child(0).text();
				result += "\n" + el.get(i).child(1).child(1).child(0).text();
				result += "\n" + el.get(i).child(0).child(0).attr("abs:href");
				result += "\n";	
			}
			
			TelegramBot.getBotLogger().info("Kinopoliskinoprogramm abgerufen"+doc.title());
			return result;

		} catch (IOException e) {
			
			e.printStackTrace();
			TelegramBot.getBotLogger().error("Kinopoliskinoprogramm: Fehler in der Abfrag");
			return "Fehler in der Abfrage";
		}
	}
}


