/**
 * 
 */
package in.parteek.beans;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;

import lombok.*;

/**
 * Created on : 2019-04-02, 3:18:57 p.m.
 *
 * @author Parteek Dheri
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Min(value = 3, message = "id must be atleast 3")
	@Max(value = 30, message = "id is at most 30")
	private int id;

	@NotNull(message = "Name cannnot be null")
	@Size(min = 5, max = 20, message = "Name must be of size between  5 & 20")
	private String name;
	@Pattern(regexp = "[A-Z]\\d[A-Z] ?\\d[A-Z]\\d", message = "Invalid postal code")
	private String postalCode;
//	@Email
	@Pattern(regexp = ".*@sheridancollege\\.ca", message = "Not a sheridan email")
	private String email;

//	@CreditCardNumber
//	private String creditCardNumber;

}