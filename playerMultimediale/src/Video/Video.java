package Video;

import java.util.Scanner;

public class Video implements videoRiproducibile {

    private String titolo;
    private int durata;
    private int volume;
    private int luminosità;


    //Costruttore
    public Video (String titolo, int durata, int volume, int luminosità){
        if (durata <= 0 || volume <= 0 || luminosità <= 0){
            System.out.println("Durata, volume e luminosità devono essere valori positivi.");
        }
        this.titolo = titolo;
        this.durata = durata;
        this.volume = volume;
        this.luminosità = luminosità;
    }


    @Override
    public int getDurata() {
        return durata;
    }

    @Override
    public int getLuminosità() {
        return luminosità;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + " #".repeat(volume));
        }
    }

    public void alzaVolume(){
        volume++;
    }

    public void abbassaVolume(){
        if(volume > 1){
            volume--;
        } else {
            System.out.println("Il volume è gia al minimo.");
        }
    }

    public void alzaLuminosità(){
        luminosità++;
    }

    public void abbassaLuminosità() {
        if (luminosità > 1){
            luminosità--;
        } else {
            System.out.println("La luminosità è già al minimo");
        }
    }

    public void stampaDettagli(){
        System.out.println("Titolo: " + titolo);
        System.out.println("Durata: " + durata + " secondi");
        System.out.println("Volume: " + volume);
        System.out.println("Luminositò: " + luminosità);
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il titolo del video:");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci la durata in secondi della registrazione:");
        double durata = scanner.nextDouble();

        System.out.println("Imposta il volume iniziale: ");
        int volume = scanner.nextInt();

        System.out.println("Imposta la luminosità:");
        int luminosità = scanner.nextInt();

        Video video = new Video(titolo, (int)durata, (int)volume, (int)luminosità);

        boolean continua = true;
                while (continua){
                    System.out.println("\nScegli un'opzione:");
                    System.out.println("1. Riproduci");
                    System.out.println("2. Alza il volume");
                    System.out.println("3. Abbassa il volume");
                    System.out.println("4. Alza la luminosità");
                    System.out.println("5. Abbassa la luminosità");
                    System.out.println("6. Mostra i dettagli");
                    System.out.println("7. Esci.");

                    System.out.println("Scelta");
                    int scelta = scanner.nextInt();

                    switch (scelta){
                        case 1:
                            System.out.println("\nRiproduci");
                            video.play();
                            break;
                        case 2:
                            System.out.println("\nAlza il volume");
                            video.alzaVolume();
                            break;
                        case 3:
                            System.out.println("\nAbbassa il volume");
                            video.abbassaVolume();
                            break;
                        case 4:
                            System.out.println("\nAlza la luminosità");
                            video.alzaLuminosità();
                            break;
                        case 5:
                            System.out.println("\nAbbassa la luminosità");
                            video.abbassaLuminosità();
                            break;
                        case 6:
                            System.out.println("\n Mostra dettagli");
                            video.stampaDettagli();
                            break;
                        case 7:
                            System.out.println("\n Esci");
                            continua = false;
                            break;
                        default:
                            System.out.println("Scleta non valida. Riprova.");
                    }
                }
        scanner.close();
    }
}