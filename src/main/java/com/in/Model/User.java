
package com.in.Model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "user_info") 
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Integer userid;
    private String name;
    private String emailid; 
    private Long  phno;
    private String gender;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private Long ssn;
    private String accStatus="Y"; 
   
}
