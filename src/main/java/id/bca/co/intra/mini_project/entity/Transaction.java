package id.bca.co.intra.mini_project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tran_id;

    @Temporal(TemporalType.DATE)
    private Date tran_date;

    private Double amount;

//    @Enumerated(EnumType.STRING)
//    private TransactionType tran_type;

    private String tran_type;

    private String norek_asal;

    private String norek_tujuan;
    
    private String notes;

//    public enum TransactionType{
//        D,
//        C
//    }

    private Long cust_id;
}
