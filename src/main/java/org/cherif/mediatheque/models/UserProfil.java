package org.cherif.mediatheque.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Table(name = "profiles")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfil implements Serializable {


    @Id
    @GeneratedValue
    private Integer id;

    private String avatar;

    private String telephone ;


    @OneToOne
    @JoinColumn(name = "user_id")
    private  UserEntity user;



}
