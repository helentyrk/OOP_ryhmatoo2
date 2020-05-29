//Helen Türk

import java.util.ArrayList;
import java.util.List;

public class Tegelane implements Üksus, Comparable<Tegelane>{
    private String nimi;
    private List<Ese> esemed;

    public Tegelane(String nimi) {
        this.nimi = nimi;
        esemed = new ArrayList<>();
    }
    public void lisaEse(Ese ese){
        esemed.add(ese);
    }

    public int punktideArv(){
        int arv = 0;
        for (Ese e: esemed) {
            int punktid = e.punktideArv();
            arv += punktid;
        }
        return arv;
    }
    //Täiendasin seda osa, et info väljastataks loetavamal kujul.
    public String info(){
        return "Tegelase nimi: " + nimi + ", esemete arv on "  + esemed.size() + ", punktide arv on " + punktideArv();
    }

    public void väljastaEsemed(){
        for (Ese e: esemed) {
            System.out.println(e);
        }
    }

    //Lisasin get-meetodi, et saaks tegelasi esemete arvu põhjal võrrelda.
    public List<Ese> getEsemed() {
        return esemed;
    }

    @Override
    public String toString() {
        return nimi;
    }

    //KT-s jäi see osa tegemata. Tegelasi võrreldakse esemete arvu põhjal.
    @Override
    public int compareTo(Tegelane t) {
        Integer arv1 = this.esemed.size();
        Integer arv2 = t.getEsemed().size();
        return arv1.compareTo(arv2);
    }
}