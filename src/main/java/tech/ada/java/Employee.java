package tech.ada.java;
import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String jobTitle;
    private double basePay;
    private double overtime;
    private double otherPay;
    private double benefits;
    private double totalPay;
    private double totalPayBenefits;
    private String year;
    private String notes;
    private String agency;
    private String status;

    public Employee(int id, String name, String jobTitle, double basePay, double overtime, double otherPay,
                    double benefits, double totalPay, double totalPayBenefits, String year, String notes,
                    String agency, String status) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.basePay = basePay;
        this.overtime = overtime;
        this.otherPay = otherPay;
        this.benefits = benefits;
        this.totalPay = totalPay;
        this.totalPayBenefits = totalPayBenefits;
        this.year = year;
        this.notes = notes;
        this.agency = agency;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getBasePay() {
        return basePay;
    }

    public double getOvertime() {
        return overtime;
    }

    public double getOtherPay() {
        return otherPay;
    }

    public double getBenefits() {
        return benefits;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public double getTotalPayBenefits() {
        return totalPayBenefits;
    }

    public String getYear() {
        return year;
    }

    public String getNotes() {
        return notes;
    }

    public String getAgency() {
        return agency;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", basePay=" + basePay +
                ", overtime=" + overtime +
                ", otherPay=" + otherPay +
                ", benefits=" + benefits +
                ", totalPay=" + totalPay +
                ", totalPayBenefits=" + totalPayBenefits +
                ", year='" + year + '\'' +
                ", notes='" + notes + '\'' +
                ", agency='" + agency + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.basePay, basePay) == 0 &&
                Double.compare(employee.overtime, overtime) == 0 &&
                Double.compare(employee.otherPay, otherPay) == 0 &&
                Double.compare(employee.benefits, benefits) == 0 &&
                Double.compare(employee.totalPay, totalPay) == 0 &&
                Double.compare(employee.totalPayBenefits, totalPayBenefits) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(jobTitle, employee.jobTitle) &&
                Objects.equals(year, employee.year) &&
                Objects.equals(notes, employee.notes) &&
                Objects.equals(agency, employee.agency) &&
                Objects.equals(status, employee.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, jobTitle, basePay, overtime, otherPay, benefits, totalPay,
                totalPayBenefits, year, notes, agency, status);
    }
}