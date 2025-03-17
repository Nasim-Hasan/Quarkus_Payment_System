package acme.org;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class PaymentProviders {
    @Id
    @GeneratedValue
    private Long id;
    private String country;
    private String industry;
    private String payment;

    public PaymentProviders() {
    }

    public PaymentProviders(String country, String industry, String payment) {
        this.country = country;
        this.industry = industry;
        this.payment = payment;
    }

    //..Getters...//
    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getIndustry() {
        return industry;
    }

    public String getPayment() {
        return payment;
    }

    //..Setters...//
    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}