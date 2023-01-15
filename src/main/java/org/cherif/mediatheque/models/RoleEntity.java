package org.cherif.mediatheque.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class RoleEntity implements Serializable {
    @Id
    private Integer roleId;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<UserEntity> users;

}
