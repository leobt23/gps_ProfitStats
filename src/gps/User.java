package gps;

public class User {
    String name, email;
    EnumGenders gender;
    int age, totalBets;

    public User(String name, String email, EnumGenders gender, int age, int totalBets) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.totalBets = totalBets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumGenders getGender() {
        return gender;
    }

    public void setGender(EnumGenders gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTotalBets() {
        return totalBets;
    }

    public void setTotalBets(int totalBets) {
        this.totalBets = totalBets;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", totalBets=" + totalBets +
                '}';
    }
}
