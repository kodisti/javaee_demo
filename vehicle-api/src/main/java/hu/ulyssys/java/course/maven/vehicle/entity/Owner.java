package hu.ulyssys.java.course.maven.vehicle.entity;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = Owner.FIND_ALL, query = "select c from Owner c order by c.id"),
        @NamedQuery(name = Owner.FIND_BY_ID, query = "select c from Owner c where c.id=:id"),
})
@Entity
@Table(name = "vehicle_owner")
public class Owner extends AbstractEntity {

    public static final String FIND_ALL = "Owner.findAll";
    public static final String FIND_BY_ID = "Owner.findById";

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (lastName != null ? !lastName.equals(owner.lastName) : owner.lastName != null) return false;
        if (firstName != null ? !firstName.equals(owner.firstName) : owner.firstName != null) return false;
        return registrationDate != null ? registrationDate.equals(owner.registrationDate) : owner.registrationDate == null;
    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        return result;
    }
}
