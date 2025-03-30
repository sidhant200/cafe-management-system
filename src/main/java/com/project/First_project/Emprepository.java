package com.project.First_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emprepository extends JpaRepository<EmpEntity , Long> {
}
