public class Student {
    private int id;
    private String name;
    private int age;
    private int grade;

    public Student(int id, String name, int age, int grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        if (id != student.id) return false;
        if (name != student.name) return false;
        if (age != student.age) return false;
        return false;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 37 * result + id;
        result = 37 * result + name.hashCode();
        result = 37 * result + age;
        return result;
    }
}
