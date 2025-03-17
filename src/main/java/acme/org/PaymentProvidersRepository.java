package acme.org;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PaymentProvidersRepository extends CrudRepository<PaymentProviders, Long> {
    List<PaymentProviders> findById(long id);
    List<PaymentProviders> findByCountry(String country);
    List<PaymentProviders> findByIndustry(String industry);
    List<PaymentProviders> findByPayment(String payment);

}
