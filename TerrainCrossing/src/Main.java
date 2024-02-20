import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
public class Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int attempt = 5;
        int ratio = 0;
        int length = 0;
        boolean ratioControl = false;
        boolean lengthControl = false;
        boolean sizeControl = false;
        boolean control;
        int n = 0;
        //<editor-fold defaultstate="collapsed" desc="arány bekérése">
        System.out.println("Tipp: a viz aranya 40-70% lehet");
        System.out.println("Csak szamot irj be");
        do {
            try {
                control = true;
                ratioControl = true;
                System.out.print("Hany % legyen a viz aranya: ");
                ratio = Integer.parseInt(br.readLine());
                if (ratio > 70){
                    ratioControl = false;
                    throw new IOException("A viz aranya nem lehet nagyobb 70%-nal!");
                }
                if (ratio < 40){
                    ratioControl = false;
                    throw new IOException("A viz aranyanak 40%-nal nagyobbnak kell lennie!");
                }
            }
            catch(IOException | NumberFormatException ratioErr){
                ratioErr.printStackTrace();
                if (ratioControl) {
                    System.err.println("Hiba az adatbevitelnel");
                }
                attempt--;
                control = false;
                if (attempt == 0) {
                    System.out.println("Tul sok hibas probalkozas, a program kilép");
                    System.exit(1);
                }
                else{
                    System.out.println("Hatra van meg " + attempt + " probalkozas");
                }
            }
        }
        while(!control);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="út hosszának bekérése">
        System.out.println("Tipp: az ut hossza 5-50 karakter lehet");
        do{
            try{
                control = true;
                lengthControl = true;
                System.out.print("Hany karakter legyen az ut hossza: ");
                length = Integer.parseInt(br.readLine());
                if (length > 50){
                    lengthControl = false;
                    throw new IOException("Az ut hosszanak az erteke maximum 50 lehet!");
                }
                if (length < 5) {
                    lengthControl = false;
                    throw new IOException("Az ut hosszanak az erteke minimum 5-nek kell lennie!");
                }
            }
            catch(IOException | NumberFormatException lengthErr){
                lengthErr.printStackTrace();
                if (lengthControl) {
                    System.err.println("Hiba az adatbevitelnel");
                }
                attempt--;
                control = false;
                if (attempt == 0) {
                    System.out.println("Tul sok hibas probalkozas, a program kilep");
                    System.exit(1);
                }
                else{
                    System.out.println("Hatra van meg " + attempt + " probalkozas");
                }
            }
        }
        while (!control);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ugrás méretének bekérése">
        System.out.println("Tipp: 1-5 karaktert ugorhatsz");
        do{
            try{
                control = true;
                sizeControl = true;
                System.out.print("Add meg, hogy egyszerre hany pocsoját tudsz atugrani: ");
                n = Integer.parseInt(br.readLine());
                if (n <= 0 | n > 5){
                    sizeControl = false;
                    throw new IOException("Nem ugorhatsz 0-t vagy minusz erteket illetve 5-nel nagyobbat se!");
                }
            }
            catch(IOException | NumberFormatException sizeErr){
                sizeErr.printStackTrace();
                if (sizeControl) {
                    System.err.println("Hiba az adatbevitelnel");
                }
                attempt--;
                control = false;
                if (attempt == 0) {
                    System.out.println("Tul sok hibas probalkozas, a program kilep");
                    System.exit(1);
                }
                else{
                    System.out.println("Hatra van meg " + attempt + " probalkozas");
                }
            }
        }
        while (!control);
        //</editor-fold>
        int number;
        Random rnd = new Random();
        ArrayList<Integer> terrainList = new ArrayList<>(length);
        terrainList.add(1);
        int cnt = 0;
        boolean fail = false;

        for (int i = 1; i < length-1; i++){
            number = rnd.nextInt(0, 100);
            if (number > ratio){
                terrainList.add(1);
                cnt = 0;
            }
            else{
                terrainList.add(2);
                cnt++;
            }
            if (cnt > n){
                fail = true;
            }
        }
        terrainList.add(1);

        for (int j = 0; j < length; j++){

            if (terrainList.get(j) == 2){
                System.out.print(" ");
            }
            else{
                System.out.print("_");
            }
        }

        if (fail){
            System.out.println("\nSaras lettel!");
        }
        else{
            System.out.println("\nMegusztad szarazon!");
        }
    }
}
