package inc.nimbuspay.proaccountrest.payment.mapper;

import inc.nimbuspay.proaccountrest.payment.entity.AccountPayableLog;
import inc.nimbuspay.proaccountrest.payment.entity.AccountReceivableLog;
import inc.nimbuspay.proaccountrest.payment.entity.Ledger;
import inc.nimbuspay.proaccountrest.payment.request.CashInTransactionRequest;
import inc.nimbuspay.proaccountrest.payment.request.CashOutTransactionRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-30T10:08:53+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public AccountPayableLog toAccountReceivablesLog(CashOutTransactionRequest request) {
        if ( request == null ) {
            return null;
        }

        AccountPayableLog.AccountPayableLogBuilder accountPayableLog = AccountPayableLog.builder();

        accountPayableLog.destAccIban( request.getDestAccIban() );
        accountPayableLog.destAccountName( request.getDestAccountName() );
        accountPayableLog.destAccountNumber( request.getDestAccountNumber() );
        accountPayableLog.destAccountSrtCde( request.getDestAccountSrtCde() );
        accountPayableLog.iso4217Currency( request.getIso4217Currency() );
        accountPayableLog.payRef( request.getPayRef() );
        accountPayableLog.transactionSource( request.getTransactionSource() );
        accountPayableLog.transactionType( request.getTransactionType() );
        accountPayableLog.transactionValue( request.getTransactionValue() );

        return accountPayableLog.build();
    }

    @Override
    public AccountReceivableLog toAccountReceivablesLog(CashInTransactionRequest request) {
        if ( request == null ) {
            return null;
        }

        AccountReceivableLog.AccountReceivableLogBuilder accountReceivableLog = AccountReceivableLog.builder();

        accountReceivableLog.iso4217Currency( request.getIso4217Currency() );
        accountReceivableLog.payRef( request.getPayRef() );
        accountReceivableLog.sourceAccIban( request.getSourceAccIban() );
        accountReceivableLog.sourceAccountName( request.getSourceAccountName() );
        accountReceivableLog.sourceAccountNumber( request.getSourceAccountNumber() );
        accountReceivableLog.sourceAccountSrtCde( request.getSourceAccountSrtCde() );
        accountReceivableLog.transactionSource( request.getTransactionSource() );
        accountReceivableLog.transactionType( request.getTransactionType() );
        accountReceivableLog.transactionValue( request.getTransactionValue() );

        return accountReceivableLog.build();
    }

    @Override
    public Ledger toLedger(CashOutTransactionRequest request) {
        if ( request == null ) {
            return null;
        }

        Ledger.LedgerBuilder ledger = Ledger.builder();

        ledger.iso4217Currency( request.getIso4217Currency() );
        ledger.transactionType( request.getTransactionType() );
        ledger.transactionValue( request.getTransactionValue() );

        return ledger.build();
    }
}
