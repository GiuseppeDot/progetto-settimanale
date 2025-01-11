package Audio;

import java.util.Scanner;

public class recAudio implements Riproducibile {

    private String titolo;
    private int durata; //durata in secondi
    private int volume; //volume attuale


    //Costruttore
    public recAudio(String titolo, int durata, int volume) {
        if (durata <= 0 || volume <= 0){
            throw new IllegalArgumentException("Durata e volume devono essere valori positivi!");
        }

        this.titolo = titolo;
        this.durata = durata;
        this.volume = volume;

    }


    //metodo getDurata() per ottenere la durata (derivante dall'interfaccia: Riproducibile)
    @Override
    public int getDurata() {
        return durata;
    }


    //metodo play() (derivante dall'interfaccia: Riproducibile)
    @Override
    public void play() {
        for(int i = 0; i < durata; i++) {
            System.out.println(titolo + " " +"▭ ".repeat(volume));
        }
    }

    //Metodo per abbassare il volume
    public void abbassaVolume() {
        if (volume > 1) {
            volume--;
        } else {
            System.out.println("Il volume è gia al minimo!");
        }
    }

    //metodo per alzare il volume
    public void alzaVolume(){
        volume++;
    }


    //Metodo per stampare i dettagli derra registrazione audio
    public void stampaDettagli() {
        System.out.println("Titolo: " + titolo);
        System.out.println("Durata: " + durata + " secondi");
        System.out.println("Volume: " + volume);
    }


    //Metodo per il test
    public static void main (String[] args){

//        recAudio audio = new recAudio("Nome canzone ",4,6);
//        audio.stampaDettagli();
//
//        System.out.print("\nRiproduzione: ");
//        audio.play();
//
//        System.out.println("\nAbbassa volume: ");
//        audio.abbassaVolume();
//
//        System.out.println("\nAlza volume: ");
//        audio.alzaVolume();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il titolo della canzone: ");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci la durata (secondi) della registrazione: ");
        double durata = scanner.nextDouble();

        System.out.println("Inserisci il volume iniziale: ");
        int volume = scanner.nextInt();

        recAudio audio = new recAudio(titolo, (int) durata, volume);

        boolean continua = true;
        while (continua) {
            System.out.println("\nScegli un'opzione");
            System.out.println("1. Riproduci");
            System.out.println("2. Alza il volume");
            System.out.println("3. Abbassa il volume");
            System.out.println("4. Mostra dettagli");
            System.out.println("5. Esci");

            System.out.println("Scelta");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("\nRiproduci");
                    audio.play();
                    break;
                case 2:
                    audio.alzaVolume();
                    System.out.println("\nVolume aumentato");
                    break;
                case 3:
                    audio.abbassaVolume();
                    System.out.println("\nVolume diminuito");
                    break;
                case 4:
                    audio.stampaDettagli();
                    break;
                case 5:
                    continua = false;
                    System.out.println("Chiusura del player...");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");

            }
        }
        scanner.close();
    }

}
