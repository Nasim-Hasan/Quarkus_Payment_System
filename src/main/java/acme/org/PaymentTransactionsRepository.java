package acme.org;

import org.springframework.data.repository.CrudRepository;

public interface PaymentTransactionsRepository extends CrudRepository<PaymentTransactions, Long> {

}
