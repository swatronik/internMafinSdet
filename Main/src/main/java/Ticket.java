public class Ticket {
    // Обязательные поля
    private String firstName;
    private String lastName;
    private String country;
    private String gender;
    private String dateOfBirth;
    // Не обязательные поля
    private String middleName;
    private String maritalStatus;

    public Ticket() {
    }

    public Ticket withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isContainFirstName() {
        return firstName != null;
    }

    public Ticket withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isContainLastName() {
        return lastName != null;
    }

    public Ticket withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public boolean isContainCountry() {
        return country != null;
    }

    public Ticket withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public boolean isContainGender() {
        return gender != null;
    }

    public Ticket withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isContainDateOfBirth() {
        return dateOfBirth != null;
    }

    public Ticket withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public boolean isMiddleName() {
        return middleName != null;
    }

    public Ticket withMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public boolean isContainMaritalStatus() {
        return maritalStatus != null;
    }

    public void registration() {
        if (!isContainFirstName()) {
            throw new MajorFieldsException("firstName");
        }
        if (!isContainLastName()) {
            throw new MajorFieldsException("lastName");
        }
        if (!isContainGender()) {
            throw new MajorFieldsException("gender");
        }
        if (!isContainDateOfBirth()) {
            throw new MajorFieldsException("dateOfBirth");
        }
        if (!isContainCountry()) {
            throw new MajorFieldsException("country");
        }

        System.out.println(firstName + " " + lastName + " " + country + " " + gender + " "
                + dateOfBirth + " " + middleName + " " + maritalStatus);
        System.out.println("Билет зарегистрирован!");
    }
}