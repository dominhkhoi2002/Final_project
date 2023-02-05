package crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Dynasty;

public class Crawl_dynastys {
    public static void main(String[] args) throws Exception {
        ArrayList<Dynasty> dynastyList =new ArrayList<>();
        Document doc=Jsoup.connect("https://nguoikesu.com/tu-lieu/bang-doi-chieu-cac-trieu-dai-viet-nam-va-cac-trieu-dai-trung-quoc").get();
        Elements table=doc.select("table");
        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            Dynasty dynasty = new Dynasty();
            dynasty.setName(cols.get(0).text());
            dynasty.setNienHieu(cols.get(1).text());
            dynasty.setYear(cols.get(2).text());
            dynastyList.add(dynasty);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String dy = gson.toJson(dynastyList);
        Path path = Paths.get("Dynastys.json");

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                writer.append(dy);
                writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }   
}
