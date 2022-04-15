package repository;

import entity.Address;
import entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
