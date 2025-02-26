public class Main {
    public static void main(String[] args) {

        Svet svet = new Svet("mapa.csv");
        Konzole konzole = new Konzole(svet);
        konzole.start();

    }
}