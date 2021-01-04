package logic.data;

public enum EnumGenders {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String gender;

    EnumGenders(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return this.gender;
    }
}
