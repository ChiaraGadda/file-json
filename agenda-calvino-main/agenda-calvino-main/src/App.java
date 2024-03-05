import java.io.FileWriter;
import java.util.Scanner;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.*;

class Classe{
    String nome;
    String cognome;
    public Classe(String nome, String cognome){
        this.nome=nome;
        this.cognome=cognome;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        JSONArray arr = new JSONArray();

        obj.put("nome: ", "Pippo");
        obj.put("cognome: ", "Pluto");

        obj2.put("nome: ", "Paperino");
        obj2.put("cognome: ", "Topolino");

        arr.add(obj);
        arr.add(obj2);

        try(FileWriter file = new FileWriter("file.json")) {
            file.write(arr.toString());
        }catch(IOException e){
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        JSONArray objRead = null;
        try(Reader read = new FileReader("file.json")){
            objRead = (JSONArray) parser.parse(read);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(objRead.toString());
    }
}
