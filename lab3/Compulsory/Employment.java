package Compulsory;

public class Employment {
    private Company company;
    private String position;

    public Employment(Company company, String position) {
        this.company = company;
        this.position = position;
    }

    public Company getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return position + " at " + company.getName();
    }
}