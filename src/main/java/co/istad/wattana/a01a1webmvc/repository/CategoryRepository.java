package co.istad.wattana.a01a1webmvc.repository;

import co.istad.wattana.a01a1webmvc.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
