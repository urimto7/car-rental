package org.sda.RentCar.repository;

import jakarta.persistence.metamodel.SingularAttribute;
import org.sda.RentCar.model.BranchUser;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface BranchUserRepository extends JpaRepository<BranchUser, Integer>{
    List<BranchUser> findAllUsersByBranchId(Integer id);
    List<BranchUser> findAllBranchByUserId(Integer id);

}
