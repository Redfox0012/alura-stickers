import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI uri = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parser = new JsonParser();

        var paser = new JsonParser();
        System.out.println(response.body());
        List<Map<String, String>> listOfFilms = parser.parse(body);
        //System.out.println(listOfAnims.get(0));
        for (Map<String, String> map: listOfFilms
             ) {
            formatedOutputFilm(map);
        }

    }

    public static void formatedOutputFilm(Map<String, String> map){
        System.out.println("Titulo: " + map.get("title"));
        System.out.println("Poster: " + map.get("image"));
        System.out.println("Nota: " + map.get("imDbRating"));
        Double numStar = Double.parseDouble(map.get("imDbRating"));
        System.out.print("Estrelas: ");
        for (int star = 0; star < Math.round(numStar); star++){
            System.out.print("*");
        }
        System.out.println();
        System.out.println("__________________________________________________________________");
    }
}
