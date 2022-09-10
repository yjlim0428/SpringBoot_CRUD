package start.server.Domain.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import start.server.Domain.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
