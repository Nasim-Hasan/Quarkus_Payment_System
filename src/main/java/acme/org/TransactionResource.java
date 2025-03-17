package acme.org;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.jboss.resteasy.reactive.RestForm;
import java.time.LocalDateTime;
import java.util.List;

@Path("/payment_transactions")
public class TransactionResource {
    private final PaymentProvidersRepository paymentprovidersrepository;
    private final PaymentTransactionsRepository paymenttransactionsrepository;

    public TransactionResource(PaymentProvidersRepository paymentprovidersrepository, PaymentTransactionsRepository paymenttransactionsrepository) {
        this.paymentprovidersrepository = paymentprovidersrepository;
        this.paymenttransactionsrepository = paymenttransactionsrepository;
    }

    @POST
    @Produces("application/json")
    public PaymentTransactions create(@RestForm("provider_id") long provider_id, @RestForm("amount") double amount) {
       List<PaymentProviders> providers = paymentprovidersrepository.findById(provider_id);
       if(providers.isEmpty()){
           throw new IllegalArgumentException("Invalid provider id:"+provider_id);
       }
       PaymentProviders paymentProviders = providers.get(0);
       return paymenttransactionsrepository.save(new PaymentTransactions(provider_id, paymentProviders.
                                                 getCountry(), amount, LocalDateTime.now()));
    }

    @GET
    @Produces("application/json")
    public Iterable<PaymentTransactions> findAll() {
        return paymenttransactionsrepository.findAll();
    }
}