package acme.org;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class PaymentTransactions {
    @Id
    @GeneratedValue
    private Long id;
    private Long providerid;
    private String providercountry;
    private double transamount;
    private LocalDateTime curdatetime;

    public PaymentTransactions() {
    }

    public PaymentTransactions(Long providerid, String providercountry,double transamount, LocalDateTime curdatetime){
        this.providerid = providerid;
        this.providercountry = providercountry;
        this.transamount = transamount;
        this.curdatetime = curdatetime;
    }
    //..Getters...//
    public Long getId() {
        return id;
    }
    public Long getProviderid() {
        return providerid;
    }

    public String getProvidercountry() {
        return providercountry;
    }
    public double getTransamount() {
        return transamount;
    }

    public LocalDateTime getCurdatetime() {
        return curdatetime;
    }

    //..Setters...//
    public void setId(Long id) {
        this.id = id;
    }
    public void setProviderid(Long providerid){
        this.providerid = providerid;
    }
    public void setProvidercountry(String providercountry){
        this.providercountry = providercountry;
    }
    public void setTransamount(double transamount){
        this.transamount = transamount;
    }
    public void setCurdatetime(LocalDateTime curdatetime){
        this.curdatetime = curdatetime;
    }
}
