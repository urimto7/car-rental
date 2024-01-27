package org.sda.RentCar.repository;

import jakarta.persistence.metamodel.SingularAttribute;
import org.sda.RentCar.model.BranchUser;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface BranchUserRepository extends JpaRepository<BranchUser, Integer>{
    List<BranchUser> findAllUsersByBranchId(SingularAttribute<AbstractPersistable, Serializable> id);
    List<BranchUser> findAllBranchByUserId(SingularAttribute<AbstractPersistable, Serializable> id);

}
