package id.bca.co.intra.mini_project.dto;

import id.bca.co.intra.mini_project.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class InsertTransactionDTO {
    private Long tran_id;
    private Date tran_date;
    private Double amount;
//    private Transaction.TransactionType tran_type;
    private String tran_type;
    private String norek_asal;
    private String norek_tujuan;
    private String notes;
    private Long cust_id;

}
