//Helen Türk

import java.io.File;
import java.util.*;

public class Peaklass {
    static List<Ese> loeEsemed(String failinimi) throws Exception{
        List<Ese> esemed = new ArrayList<>();
        File fail = new File(failinimi);
        Scanner s = new Scanner(fail, "UTF-8");
        while (s.hasNextLine()){
            String rida = s.nextLine();
            String[] andmed = rida.split(";");
            String nimetus = andmed[0];
            int punktideArv = Integer.parseInt(andmed[1]);
            Ese e = new Ese(nimetus, punktideArv);
            esemed.add(e);
        }
        s.close();
        return esemed;
    }


    public static void main(String[] args) throws Exception {
        List<Ese> esemed = loeEsemed("esemed.txt");

        //Loon viis tegelast
        Tegelane t1 = new Tegelane("Koopamees");
         Tegelane t2 = new Tegelane("Tormaja");
         Tegelane t3 = new Tegelane("Kalur");
         Tegelane t4 = new Tegelane("Haldjas");
         Tegelane t5 = new Tegelane("Uss");

        Tegelane[] tegelased = new Tegelane[5];
        tegelased[0] = t1;
        tegelased[1] = t2;
        tegelased[2] = t3;
        tegelased[3] = t4;
        tegelased[4] = t5;

        //Iga tegelase jaoks juhuslik arv n vahemikust [2,10] - esemete arv, mis igale tegelasele antakse.
        //KT-s oli see osa poolik - tegin siis eraldi arvu genereerimise ja esemete jagamise, aga mõistlikum on teha
        //kahekordse tsükliga, kus kõigepealt genereerin arvu, siis segan ära esemete listi ning seejärel jagan
        //uue tsükliga tegelastele vastava arvu elemente.
        for (Tegelane t: tegelased) {
            int juhuslikArv = (int)Math.round(Math.random()*(10-2)+1)+2;
            Collections.shuffle(esemed); //Esemete list iga tegelase jaks uuesti ümber järjestatud.
            for (int j = 0; j < juhuslikArv; j++){
                t.lisaEse(esemed.get(j)); //Tegelasele lisatakse ese.
            }
        }

        //Väljastab tegelase info ja juhuslikult saadud esemed.
        for (Tegelane t: tegelased) {
            System.out.println(t.info());
            t.väljastaEsemed();
            System.out.println("\n");
        }

        //Tegelaste massivi põhjal luuakse mäng.
        Mäng mäng = new Mäng(tegelased);

        //Väljastatakse suurima esemete arvuga tegelane. KT-s jäi see osa poolikuks. Täiendasin meetodit.
        System.out.println(mäng.suurimaEsemeteArvuga());
    }
}
