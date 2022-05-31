import java.io.IOException;

public class Student {

    private String Name;
    private int Age;
    private String Data;

    public Student(String name, String data, int age) {
        Name = name;
        Age = age;
        Data = data;
    }

    public String GetName() {
        return Name;
    }

    public int GetAge() {
        return Age;
    }

    public String GetData() {
        return Data;
    }

    public String ToString() {
        return Name+ " " + Data + " " + Integer.toString(Age);
    }

    public static Student Parse(String str) throws IOException, ZlyStudent {
        String[] data = str.split(" ");
        if (data.length != 3) {
            throw new ZlyStudent();
        }
        return new Student(data[0], data[1], Integer.parseInt(data[2]));
    }
}