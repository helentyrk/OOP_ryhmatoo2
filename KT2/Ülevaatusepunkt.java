import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Ülevaatusepunkt {
    private static List<Auto> loeAutod(String failinimi) throws IOException, ParseException {
        List<Auto> autod = new ArrayList<>();

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(new File("autod.bin")));
            int arv = dis.readInt();

            for (int i = 0; i < arv; i++){
                String regNumber = dis.readUTF();
                String omanik = dis.readUTF();
                String ülevaatus = dis.readUTF();

                // KT-s ei jõudnud selle teisenduseni
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(ülevaatus, formatter);

                Auto a = new Auto(regNumber, omanik, localDate);
                autod.add(a);
            }

        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        return autod;
    }

    private static Map<String, List<Auto>> omanikeKaupa(List<Auto> autodeList){
        Map<String, List<Auto>> omanikuti = new HashMap<>();

        for (Auto a : autodeList) {
            List<Auto> autod = new ArrayList<>();

            //Korduvaid elemente ei ole
            ArrayList uniqueList = (ArrayList) autod.stream().distinct().collect(Collectors.toList());

            if (!omanikuti.containsKey(a.getOmanik())) {
                autod.add(a);
                omanikuti.put(a.getOmanik(), uniqueList);
            }
            omanikuti.get(a.getOmanik()).add(a);
        }
        return omanikuti;
    }

    static void salvestaAutod(String failinimi, List<Auto> autod) throws IOException {
        File fail = new File(failinimi);
        if (!fail.exists()) {
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fail))) {
                dos.write(autod.size());
                for (Auto a : autod) {
                    dos.writeUTF(a.getRegistreerimisnumber() + " " + a.getOmanik() + " " + a.getÜlevaatus() + "\n");
                }
            }
        }
        //See oli lahendusest puudu - kui fail eksisteerib, siis kirjutab üle
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fail.getAbsoluteFile()))) {
            dos.write(autod.size());
            for (Auto a : autod) {
                dos.writeUTF(a.getRegistreerimisnumber() + " " + a.getOmanik() + " " + a.getÜlevaatus() + "\n");
            }
        }
    }


    public static void main(String[] args) throws IOException, ParseException {
        List<Auto> autod = (loeAutod("autod.bin"));
        Collections.sort(autod);
        //System.out.println(autod);

        Map<String, List<Auto>> omanikuti = omanikeKaupa(autod);
        //System.out.println(omanikuti);

        List<Auto> kõikAutod = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Kas soovid ülevaatust (T)eostada, autosid (V)aadata või (S)alvestada ja lõpetada?");
        String sisend = scanner.nextLine();

        while (!sisend.equals("S")) {
            if (sisend.equals("V")) {
                System.out.println("On olemas järgmiste omanike autod: " + omanikuti.keySet());
                System.out.println("Sisesta omaniku nimi: ");
                String nimi = scanner.nextLine();

                if (!omanikuti.keySet().contains(nimi)) {
                    System.exit(1);
                }
                //Kui on mitu autot, siis paneb tulemuse eraldi reale
                List<Auto> tulemus = omanikuti.get(nimi);
                for (Auto a : tulemus) {
                    System.out.println(a);
                }
            }
            if (sisend.equals("T")) {
                Auto a = autod.get(0);
                System.out.println(a.toString());
                a.teostaÜlevaatus();
                kõikAutod.add(a);
                autod.remove(0);
                System.out.println("Kas soovid ülevaatust (T)eostada, autosid (V)aadata või (S)alvestada ja lõpetada?");
                sisend = scanner.nextLine();
            }
            System.out.println("Kas soovid ülevaatust (T)eostada, autosid (V)aadata või (S)alvestada ja lõpetada?");
            sisend = scanner.nextLine();
        }
        salvestaAutod("autod.txt", kõikAutod);
        System.out.println("Autod salvestatud!");
        System.exit(1);
    }
}