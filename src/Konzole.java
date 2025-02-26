import java.util.HashMap;
import java.util.Scanner;

public class Konzole {

    private boolean konec2 = false;
    private HashMap<String, Prikaz> mapa = new HashMap<>();
    private Svet svet;

    public Konzole(Svet svet) {
        this.svet = svet;
    }

    public void inicialzace(){
        mapa.put("stop", new Stop());
    }

    Scanner scanner = new Scanner(System.in);

    public void provedPrikaz(){
        System.out.println(">> ");
        String prikaz2 = scanner.nextLine();
        prikaz2 = prikaz2.trim();
        prikaz2 = prikaz2.toLowerCase();

        if(prikaz2.startsWith("jdi")){
            String smer = prikaz2.substring(4);
            Prikaz prikaz = new Jdi(smer);
            System.out.println(">> " + prikaz.proved(svet));
            if(prikaz.konec()){
                konec2 = true;
            }
            } else if (mapa.containsKey(prikaz2)) {
            Prikaz prikaz = mapa.get(prikaz2);
            System.out.println(">> " + prikaz.proved(svet));
            if(prikaz.konec()){
                konec2 = true;
            }
        }else{
            System.out.println(">> Neznamy prikaz");
        }
    }

    public void start(){
        inicialzace();
        System.out.println("Vitej ve hre! Napis prikaz jdi zoo nebo konec");
        try{
            do{
                provedPrikaz();
            }while(!konec2);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
