package inc.nimbuspay.proaccountrest.payment.mapper;

import inc.nimbuspay.proaccountrest.payment.entity.AccountPayableLog;
import inc.nimbuspay.proaccountrest.payment.entity.AccountReceivableLog;
import inc.nimbuspay.proaccountrest.payment.entity.Ledger;
import inc.nimbuspay.proaccountrest.payment.request.CashInTransactionRequest;
import inc.nimbuspay.proaccountrest.payment.request.CashOutTransactionRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T16:50:44+0530",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.3 (Microsoft)"
)
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public AccountPayableLog toAccountReceivablesLog(CashOutTransactionRequest request) {
        if ( request == null ) {
            return null;
        }

        AccountPayableLog.AccountPayableLogBuilder accountPayableLog = AccountPayableLog.builder();

        accountPayableLog.transactionType( request.getTransactionType() );
        accountPayableLog.transactionValue( request.getTransactionValue() );
        accountPayableLog.iso4217Currency( request.getIso4217Currency() );
        accountPayableLog.destAccountNumber( request.getDestAccountNumber() );
        accountPayableLog.destAccountSrtCde( request.getDestAccountSrtCde() );
        accountPayableLog.destAccIban( request.getDestAccIban() );
        accountPayableLog.destAccountName( request.getDestAccountName() );
        accountPayableLog.transactionSource( request.getTransactionSource() );
        accountPayableLog.payRef( request.getPayRef() );

        return accountPayableLog.build();
    }

    @Override
    public AccountReceivableLog toAccountReceivablesLog(CashInTransactionRequest request) {
        if ( request == null ) {
            return null;
        }

        AccountReceivableLog.AccountReceivableLogBuilder accountReceivableLog = AccountReceivableLog.builder();

        accountReceivableLog.transactionType( request.getTransactionType() );
        accountReceivableLog.transactionValue( request.getTransactionValue() );
        accountReceivableLog.iso4217Currency( request.getIso4217Currency() );
        accountReceivableLog.sourceAccountNumber( request.getSourceAccountNumber() );
        accountReceivableLog.sourceAccountSrtCde( request.getSourceAccountSrtCde() );
        accountReceivableLog.sourceAccIban( request.getSourceAccIban() );
        accountReceivableLog.sourceAccountName( request.getSourceAccountName() );
        accountReceivableLog.transactionSource( request.getTransactionSource() );
        accountReceivableLog.payRef( request.getPayRef() );

        return accountReceivableLog.build();
    }

    @Override
    public Ledger toLedger(CashOutTransactionRequest request) {
        if ( request == null ) {
            return null;
        }

        Ledger.LedgerBuilder ledger = Ledger.builder();

        ledger.transactionType( request.getTransactionType() );
        ledger.transactionValue( request.getTransactionValue() );
        ledger.iso4217Currency( request.getIso4217Currency() );

        return ledger.build();
    }
}
