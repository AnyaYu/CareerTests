package enums;

public enum JobCategories {
    QA("Software Test Engineering");

    public String value;

    JobCategories(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
