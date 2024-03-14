package cma.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;
@Data
public class CreateContactDTO {

    @NotNull(message = "The Id cannot be null")
    private Integer id;

    @NotBlank(message = "First Name cannot be empty")
    @NotNull(message = "First Name cannot be null")
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    @NotNull(message = "Last Name cannot be null")
    private String lastName;

    @NotNull(message = "Date of Birth cannot be null")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Adress cannot be empty")
    @NotNull(message = "Adress cannot be null")
    private String address;

    @NotNull(message = "Mobile Number cannot be null")
    private Integer mobileNumber;


    public CreateContactDTO() {
        id = 0;
        firstName = "";
        lastName = "";
        dateOfBirth = null;
        address = "";
        mobileNumber = 0;
    }

    public CreateContactDTO(Integer id, String firstName, String lastName, LocalDate dateOfBirth, String address, Integer mobileNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
