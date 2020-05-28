import java.time.LocalDate;

public class Auto implements Comparable<Auto>{
    private String registreerimisnumber;
    private String omanik;
    private LocalDate ülevaatus;


    public Auto(String registreerimisnumber, String omanik, LocalDate ülevaatus) {
        this.registreerimisnumber = registreerimisnumber;
        this.omanik = omanik;
        this.ülevaatus = ülevaatus;
    }

    public String getRegistreerimisnumber() {
        return registreerimisnumber;
    }

    public String getOmanik() {
        return omanik;
    }

    //nüüd annab localDate, mitte  Date
    public LocalDate getÜlevaatus() {
        return ülevaatus;
    }

    public void teostaÜlevaatus(){
        if (LocalDate.now().plusYears(1).isBefore(getÜlevaatus())){
            throw new ÜlevaatuseErind("Ülevaatus on ebavajalik! Ülevaatus ei ole tehtud! Järgmine ülevaatus:  " + getÜlevaatus());
        }
        ülevaatus = this.ülevaatus.plusYears(2);
        System.out.println("Ülevaatus on tehtud. Järgmine ülevaatus: " + ülevaatus);
    }

    @Override
    public String toString() {
        return "Auto: " + registreerimisnumber + " " + omanik + " " + this.ülevaatus;
    }

    @Override
    public int compareTo(Auto auto) {
        return getÜlevaatus().compareTo(auto.getÜlevaatus());
    }
}
