import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

class News extends Thread {
	public void run() {
		StringBuilder response = new StringBuilder();

		Date date3 = new Date();
		System.out.println("News Fetching Started at : " + date3);

		try {
			String url = "https://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=bb2b55fa1b4b492ea9257dec9dfdbe0d";
			URL NewsUrl = new URL(url);

			URLConnection connection = NewsUrl.openConnection();

			InputStream inputStream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(reader);

			String line = "";
			while ((line = buffer.readLine()) != null) {
				response.append(line + "\n");
			}
			buffer.close();
			reader.close();

			System.out.println("Response from Server: " + response);

		} catch (Exception e) {
			System.out.println("Some Error: " + e);
		}
		Date date4 = new Date();
		System.out.println("News Fetching ended at : " + date4);
	}

}

public class FetchNews {

	public static void main(String[] args) {
		System.out.println("==App Started===");

		Date date1 = new Date();
		System.out.println("App Started at : " + date1);

		News A = new News();
		A.start();

		Date date2 = new Date();
		System.out.println("App Ended at : " + date2);

		System.out.println("==App Finished===");
	}
}