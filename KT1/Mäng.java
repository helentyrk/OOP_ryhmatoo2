//Helen Türk

import java.util.Arrays;
import java.util.Collections;

public class Mäng {
    private Tegelane[] tegelasteNimekiri;

    public Mäng(Tegelane[] tegelasteNimekiri) {
        this.tegelasteNimekiri = tegelasteNimekiri;
    }

    //Selleni KT-s ei jõudndud. Meetod väljastab suurima esemete arvuga tegelase.
    //Sorteerib tegelaste nimekirja esemete arvu põhjal - väiksemast kõige suuremani -
    // ning tagastab siis viimase elemendi.
    public Tegelane suurimaEsemeteArvuga(){
        Arrays.sort(tegelasteNimekiri);
        int viimane = tegelasteNimekiri.length-1;
        return tegelasteNimekiri[viimane];
    }
}
