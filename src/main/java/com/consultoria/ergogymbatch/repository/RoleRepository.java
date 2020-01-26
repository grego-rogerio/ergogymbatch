package com.consultoria.ergogymbatch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consultoria.ergogymbatch.model.Role;
import com.consultoria.ergogymbatch.model.RoleName;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(RoleName roleName);
}
