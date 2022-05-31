import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

class ZlaData extends Exception {}
class ZlyWiek extends Exception {}
class ZlaOpcja extends Exception {}
class Zleimie extends Exception {}

class Main {
    public static Scanner skaner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        while (true) {

            try {
                int opcja = 0;
                opcja = menu();

                switch (opcja) {
                    case 1: {
                        System.out.println();
                        OP1();
                        break;
                    }
                    case 2: {
                        System.out.println();
                        OP2();
                        break;
                    }
                }
            } catch (IOException e) {

                System.out.println("Wykryto bład w dacie urodzenia!");
            } catch (ZlyWiek e) {
                System.out.println("Wykryto błędny wiek");
            } catch (ZlaOpcja e) {
                System.out.println("Wpisz liczbę!");
            }
        }

    }

    public static int menu() throws ZlaOpcja {
        int numer = 0;

        System.out.println();
        System.out.println();
        System.out.println("Menu: ");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wypisz listę studentów");
        System.out.println("3. Wyszukaj po imieniu");
        System.out.println("0. Wyjście z programu");
        System.out.print("Wybierz opcję: ");

        try {
            numer = skaner.nextInt();
            return numer;
        } catch (InputMismatchException e) {
            throw new ZlaOpcja();
        }
    }

    public static void OPI() throws IOException, Zleimie, ZlaData, ZlyWiek {

        Service1 s = new Service1();
        int wiek;
        String imie;
        String data;
      
        imie = ();
        data = PD();
        wiek = PW();

        s.addStudent(new Student(imie, data, wiek));
        System.out.println("Dodano nowego studenta");

    }

    public static String PD() throws ZlaData {
        String data;
        System.out.print("Podaj datę urodzenia DD-MM-YYYY: ");
        data = skaner.nextLine();
        try {
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            format.setLenient(false);
            format.parse(data);

            String[] poprawnsc = data.split("-");
            if (Integer.parseInt(poprawnsc[0]) < 0 || Integer.parseInt(poprawnsc[0]) > 31) {
                throw new ZlaData();
            }
            if (Integer.parseInt(poprawnsc[1]) < 0 || Integer.parseInt(poprawnsc[1]) > 12) {
                throw new ZlaData();
            }
            if (Integer.parseInt(poprawnsc[2]) < 0 || Integer.parseInt(poprawnsc[2]) > 2022) {
                throw new ZlaData();
            }
            return data;

        } catch (ParseException e) {
            throw new ZlaData();
        }
    }


    public static int PW() throws ZlyWiek {
        int wiek;
        System.out.print("Podaj Podaj wiek: ");
        wiek = skaner.nextInt();
        if (wiek < 0 || wiek > 100) {
            throw new ZlyWiek();
        }
        return wiek;
    }

    public static void OP1() throws IOException {

        Service1 s = new Service1();
        var students = s.getStudents();
        for (Student current : students) {
            System.out.println(current.ToString());
        }

    }

    public static void OP2() throws IOException {
        String imie;
        skaner.nextLine();
        System.out.print("Podaj imię: ");
        imie = skaner.nextLine();
        var student = (new Service1()).findStudentByName(imie);
        if (student == null) {
            System.out.println("Nie znaleziono");
        } else {
            System.out.print("Wynik: ");
            System.out.println(student.ToString());
        }
    }

}