package org.sda.RentCar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branch_users")
public class BranchUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany
    @JoinColumn(name = "id_users",
            referencedColumnName = "id_users")
    private User user;
    @OneToMany
    @JoinColumn(name = "id_branch",
            referencedColumnName = "id_branch")
    private Branch branch;

}
