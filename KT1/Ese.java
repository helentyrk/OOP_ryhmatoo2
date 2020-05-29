//Helen Türk

public class Ese implements Üksus{
    private String nimetus;
    private int punktideArv;

    public Ese(String nimetus, int punktideArv) {
        this.nimetus = nimetus;
        this.punktideArv = punktideArv;
    }
    public int punktideArv(){
        return punktideArv;
    }
    public String info(){
        return nimetus;
    }

    public String toString() {
        return nimetus + ": " + punktideArv;
    }
}
