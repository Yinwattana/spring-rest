package co.istad.wattana.a01a1webmvc.repository;

import co.istad.wattana.a01a1webmvc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
