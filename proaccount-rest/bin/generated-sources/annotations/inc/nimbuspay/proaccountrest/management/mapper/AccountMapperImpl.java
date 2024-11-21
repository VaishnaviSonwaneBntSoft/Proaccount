package inc.nimbuspay.proaccountrest.management.mapper;

import inc.nimbuspay.proaccountrest.management.entity.Account;
import inc.nimbuspay.proaccountrest.management.request.AccountRequest;
import inc.nimbuspay.proaccountrest.management.response.AccountResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-30T10:08:53+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account accountRequestToAccount(AccountRequest accountRequest) {
        if ( accountRequest == null ) {
            return null;
        }

        Account.AccountBuilder account = Account.builder();

        account.accountOwner( accountRequest.getAccountOwner() );
        account.iso4217Currency( accountRequest.getIso4217Currency() );
        account.product( accountRequest.getProduct() );

        return account.build();
    }

    @Override
    public AccountResponse accountToAccountResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountResponse.AccountResponseBuilder accountResponse = AccountResponse.builder();

        accountResponse.accountId( account.getAccountId() );
        accountResponse.accountNumber( account.getAccountNumber() );
        accountResponse.accountOwner( account.getAccountOwner() );
        accountResponse.accountType( account.getAccountType() );
        accountResponse.deleted( account.isDeleted() );
        accountResponse.iso4217Currency( account.getIso4217Currency() );
        accountResponse.ledgerBalance( account.getLedgerBalance() );
        accountResponse.product( account.getProduct() );
        accountResponse.timestamp( account.getTimestamp() );

        return accountResponse.build();
    }
}
