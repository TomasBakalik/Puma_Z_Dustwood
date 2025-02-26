import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Svet {

    private HashMap<String, Mistnost> mistnosti = new HashMap<>();
    private Mistnost aktualniMistnost;

    public Svet(String soubor){
        nacistSvetZeSouboru(soubor);

        if(mistnosti.containsKey("namesti")){
            aktualniMistnost = mistnosti.get("namesti");
        }else{
            System.out.println("Chyba, mistnost namesti pro start hry nebyla nalezena v souboru");
        }
    }

    public void nacistSvetZeSouboru(String soubor){
        try(BufferedReader br = new BufferedReader(new FileReader(soubor))){
            ArrayList<String[]> data = new ArrayList<>();
            String radek = "";

            while((radek = br.readLine()) != null){
                data.add(radek.split(";"));
            }

            for(String[] vstup : data){
                mistnosti.put(vstup[0].toLowerCase(), FactoryMistnost.vytvorMistnost(vstup[0]));
            }

            for(String[] vstup: data){
                Mistnost mistnost = mistnosti.get(vstup[0].toLowerCase());
                for(int i = 1; i < vstup.length; i++){
                    if(!vstup[i].isEmpty()){
                        Mistnost soused = mistnosti.get(vstup[i].toLowerCase());
                        if(soused != null){
                            mistnost.nastavitVychod(vstup[i].toLowerCase(), soused);
                        }else{
                            System.out.println("Chyba: Mistnost " + vstup[i] + " nebyla nalezena");
                        }
                    }
                }
            }

        }catch (IOException e){
            System.out.println("Chyba pri nacitani souboru: " + e.getMessage());
        }
    }

    public Mistnost getAktualniMistnost(){
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost aktualniMistnost){
        this.aktualniMistnost = aktualniMistnost;
    }

}
