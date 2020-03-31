import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Testklass {
    public static void main(String[] args) {
        Kontsert kontsert1 = new Kontsert("Päike", "Vanemuise kontserdisaal", "02-04-2020", 35, 15);

        //Programmi tutvustav tekst
        System.out.println("Tere tulemast! Selle programmi abil saab osta pileteid...");

        //Kasutajalt küsitakse

        //Soovitud kontsert
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Sisesta soovitud kontserdi nimi: ");
        String soovitudKontserdiNimi = scan1.next();
        System.out.println(soovitudKontserdiNimi);

        //Toimumise kuupäev - peaks vist täiendama kellaajaga või tegema uue küsimise, et oleks kuupäev ja kellaaeg eraldi
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Scanner scan2 = new Scanner(System.in);

        System.out.println("Sisesta kuupäev kujul: kuu-päev-aasta");
        System.out.print("Sisesta kuupäev: ");
        String soovitudKuupäev = scan2.nextLine();

        try {
            Date date = sdf.parse(soovitudKuupäev);

            sdf = new SimpleDateFormat("EEE, d MMM yyyy");
            System.out.println("Soovitud kuupäev: " + sdf.format(date));
        } catch (ParseException e) {
            System.out.println("Parse Exception");
        }

        //Soovitud piletite arv
        Scanner scan3 = new Scanner(System.in);
        System.out.println("Sisesta soovitud piletite arv");
        int soovitudPiletiteArv = scan3.nextInt();
        System.out.println("Soovitud pileteid: " + soovitudPiletiteArv);

        //Kas soovitakse kohta valida või tuleb juhuslikult genereerida?
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Kas soovite kohta/kohti valida?");
        String valik = scan4.next();
        System.out.println(valik);

        if (valik == "jah"){
            for (int i = 0; i < soovitudPiletiteArv; i++) {
                //Soovitud rida
                Scanner scan5 = new Scanner(System.in);
                System.out.println("Sisesta soovitud rida");
                int soovitudRida = scan5.nextInt();
                System.out.println("Soovitud rida: " + soovitudRida);

                //Soovitud koht
                Scanner scan6 = new Scanner(System.in);
                System.out.println("Sisesta soovitud koht");
                int soovitudKoht = scan6.nextInt();
                System.out.println("Soovitud koht: " + soovitudKoht);
            }
        } else if (valik=="ei"){
            System.out.println("Antakse juhuslikud kohad..");
        }
    }
}
