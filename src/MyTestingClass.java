import java.util.Random;

public class MyTestingClass {
    private int id;
    private String name;
    private int age;

    public MyTestingClass(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + id;
        for (int i = 0; i < name.length(); i++) {
            hash = 37 * hash + name.charAt(i);
        }
        hash = 37 * hash + age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass other = (MyTestingClass) obj;
        if (id != other.id) return false;
        if (!name.equals(other.name)) return false;
        return age == other.age;
    }

    public static MyTestingClass generateRandomData(){
        Random random = new Random();

        int id = random.nextInt(100000);
        String name = "";
        int nameLength = random.nextInt(3) + 8;
        for (int i = 0; i < nameLength; i++) {
            char c = (char) ('a' + random.nextInt(26));
            name += c;
        }
        int age = random.nextInt(100);

        return new MyTestingClass(id, name, age);
    }



}
