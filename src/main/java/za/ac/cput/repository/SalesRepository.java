package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Sales;
@Repository
public interface SalesRepository extends JpaRepository<Sales, String> {
   // void delete(String  salesID);
}
