package acme.org;

import jakarta.ws.rs.*;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestQuery;
import java.util.List;

@Path("/payment_providers")
public class PaymentResource {
    private final PaymentProvidersRepository paymentprovidersrepository;
    public PaymentResource(PaymentProvidersRepository paymentprovidersrepository) {
        this.paymentprovidersrepository = paymentprovidersrepository;
    }
    @GET
    @Produces("application/json")
    public Iterable<PaymentProviders> findAll() {
        return paymentprovidersrepository.findAll();
    }

    @GET
    @Path("/id/{id}")
    @Produces("application/json")
    public List<PaymentProviders> findById(long id) {
        return paymentprovidersrepository.findById(id);
    }

    @GET
    @Path("/country/{country}")
    @Produces("application/json")
    public List<PaymentProviders> findByCountry(String country) {
        return paymentprovidersrepository.findByCountry(country);
    }

    @GET
    @Path("/industry/{industry}")
    @Produces("application/json")
    public List<PaymentProviders> findByIndustry(String industry) {
        return paymentprovidersrepository.findByIndustry(industry);
    }
    @GET
    @Path("/payment/{payment}")
    @Produces("application/json")
    public List<PaymentProviders> findByPayment(String payment) {
        return paymentprovidersrepository.findByPayment(payment);
    }

    @POST
    @Path("/registration")
    @Produces("application/json")
    public PaymentProviders create(@RestForm("country") String country, @RestForm("industry") String industry, @RestForm("payment") String payment) {
        return paymentprovidersrepository.save(new PaymentProviders(country, industry, payment));
    }

    @DELETE
    @Path("delete/{id}")
    public String delete(long id) {
        paymentprovidersrepository.deleteById(id);
        return "Deleted successfully";
    }

    @PUT
    @Path("update/{id}")
    @Produces("application/json")
    public PaymentProviders update(long id, @RestQuery("country") String country, @RestQuery("industry") String industry, @RestQuery("payment") String payment) {
        PaymentProviders paymentProviders = paymentprovidersrepository.findById(id).get(0);
        paymentProviders.setCountry(country);
        paymentProviders.setIndustry(industry);
        paymentProviders.setPayment(payment);
        return paymentprovidersrepository.save(paymentProviders);
    }

}
