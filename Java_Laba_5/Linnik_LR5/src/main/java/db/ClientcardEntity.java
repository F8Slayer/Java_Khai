package db;

import javax.persistence.*;

@Entity
@Table(name = "clientcard", schema = "databasecourse", catalog = "")
public class ClientcardEntity {
    private int idClientCard;
    private int number;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String phone;

    @Id
    @Column(name = "idClientCard", nullable = false)
    public int getIdClientCard() {
        return idClientCard;
    }

    public void setIdClientCard(int idClientCard) {
        this.idClientCard = idClientCard;
    }

    @Basic
    @Column(name = "Number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "FirstName", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "SecondName", nullable = false, length = 45)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "ThirdName", nullable = true, length = 45)
    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    @Basic
    @Column(name = "Phone", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientcardEntity that = (ClientcardEntity) o;

        if (idClientCard != that.idClientCard) return false;
        if (number != that.number) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (thirdName != null ? !thirdName.equals(that.thirdName) : that.thirdName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClientCard;
        result = 31 * result + number;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (thirdName != null ? thirdName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientcardEntity{" +
                "idClientCard=" + idClientCard +
                ", number=" + number +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
