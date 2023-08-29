package trade.engine.kafka.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class Trade {
	
    private String tradeId;
    private int version;
    private String counterParty;
    private String bookId;
    private LocalDate maturityDate;
    private LocalDate createdDate;
    private String expiredFlag;

}
