
import com.fasterxml.jackson.databind.ObjectMapper;
import database.NoSQLConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.log4j.Logger;
import org.bson.Document;

public class HttpRequest {

    static Logger log = Logger.getLogger(NoSQLConnection.class.getName());
    NoSQLConnection noCon = new NoSQLConnection();
    StringBuilder response = null;
    String fileName = "C:\\data/response.json";

    public StringBuilder getResponse() {
        return response;
    }

    public StringBuilder sendGet() throws Exception {
        noCon.connect();
        String USER_AGENT = "Mozilla/5.0";
        String url = "https://api.exchangeratesapi.io/latest?symbols=USD,EUR&base=TRY";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()))) {
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            log.info(response);
        } else {
            log.warn("GET request not worked");
        }
        return response;
    }

    public void convertValue() throws IOException, Exception {
        sendGet();

        ObjectMapper objectMapper = new ObjectMapper();
        Document doc = (Document) readJsonSimpleDemo(fileName);

        //objectMapper.writeValue(new File("C:\\data/doc.json"),response);
        noCon.getCollection().insertOne(doc);

    }

    public static Object readJsonSimpleDemo(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        return reader;
    }

}
