package crawl;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.BufferedWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

import models.Event;

public class crawl_event {
    public static void main(String[] args) throws Exception {
        String url = "https://vi.wikipedia.org/wiki/Niên_biểu_lịch_sử_Việt_Nam";
        Document doc = Jsoup.connect(url).get();

        Elements pTag = doc.select("p");
        Elements ddTag = doc.select("dd");
        List <Event> EventList = new ArrayList<Event>();
        
        pTag.remove(0);

        for(Element p:pTag) {
            try{
                Element timeTag = p.child(0);
                Element contentTag = p.clone();
                contentTag.childNode(0).remove();
                if (contentTag.text().equals("")){
                    continue;
                }
                Event event = new Event(timeTag.text(), contentTag.text());
                EventList.add(event);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        for(Element dd: ddTag){
            try{
                Element timeTag = dd.child(0);
                Element contentTag = dd.clone();
                contentTag.childNode(0).remove();
                Event event = new Event(timeTag.text(), contentTag.text());
                EventList.add(event);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String Str_Event = gson.toJson(EventList);
        Path path = Paths.get("Events.json");

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.append(Str_Event);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

