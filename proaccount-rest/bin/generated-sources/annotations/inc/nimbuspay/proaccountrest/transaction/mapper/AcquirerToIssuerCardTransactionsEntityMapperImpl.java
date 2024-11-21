package inc.nimbuspay.proaccountrest.transaction.mapper;

import inc.nimbuspay.commonobjectmodel.environment.Environment;
import inc.nimbuspay.commonobjectmodel.general.AdditionalData;
import inc.nimbuspay.commonobjectmodel.general.LocalData;
import inc.nimbuspay.commonobjectmodel.model.acquirertoissuercardmessages.AcquirerToIssuerCardTransactionsModel;
import inc.nimbuspay.commonobjectmodel.party.Acquirer;
import inc.nimbuspay.commonobjectmodel.party.InitiatingParty;
import inc.nimbuspay.commonobjectmodel.party.Issuer;
import inc.nimbuspay.commonobjectmodel.transaction.AccountDetails;
import inc.nimbuspay.commonobjectmodel.transaction.Card;
import inc.nimbuspay.commonobjectmodel.transaction.TransactionAmounts;
import inc.nimbuspay.commonobjectmodel.transaction.TransactionIdentification;
import inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.AccountFrom;
import inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.AccountTo;
import inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Transaction;
import inc.nimbuspay.proaccountrest.transaction.model.AcquirerToIssuerCardTransactionsEntityModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-30T10:08:53+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class AcquirerToIssuerCardTransactionsEntityMapperImpl implements AcquirerToIssuerCardTransactionsEntityMapper {

    @Override
    public AcquirerToIssuerCardTransactionsEntityModel acquirerToIssuerCardTransactionsModelToAcquirerToIssuerCardTransactionsEntityModel(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return null;
        }

        AcquirerToIssuerCardTransactionsEntityModel acquirerToIssuerCardTransactionsEntityModel = new AcquirerToIssuerCardTransactionsEntityModel();

        acquirerToIssuerCardTransactionsEntityModel.setTransaction( transactionToTransaction( acquirerToIssuerCardTransactionsModel.getTransaction() ) );
        acquirerToIssuerCardTransactionsEntityModel.setAcquirer( acquirerToAcquirer( acquirerToIssuerCardTransactionsModelEnvironmentAcquirer( acquirerToIssuerCardTransactionsModel ) ) );
        acquirerToIssuerCardTransactionsEntityModel.setIssuer( issuerToIssuer( acquirerToIssuerCardTransactionsModelEnvironmentIssuer( acquirerToIssuerCardTransactionsModel ) ) );
        acquirerToIssuerCardTransactionsEntityModel.setCard( cardToCard( acquirerToIssuerCardTransactionsModelEnvironmentCard( acquirerToIssuerCardTransactionsModel ) ) );
        acquirerToIssuerCardTransactionsEntityModel.setInitiatingParty( initiatingPartyToInitiatingParty( acquirerToIssuerCardTransactionsModel.getInitiatingParty() ) );

        return acquirerToIssuerCardTransactionsEntityModel;
    }

    protected AccountFrom accountDetailsToAccountFrom(AccountDetails accountDetails) {
        if ( accountDetails == null ) {
            return null;
        }

        AccountFrom accountFrom = new AccountFrom();

        accountFrom.setAccountId( accountDetails.getAccountId() );
        accountFrom.setAccountName( accountDetails.getAccountName() );
        accountFrom.setAccountType( accountDetails.getAccountType() );

        return accountFrom;
    }

    protected AccountTo accountDetailsToAccountTo(AccountDetails accountDetails) {
        if ( accountDetails == null ) {
            return null;
        }

        AccountTo accountTo = new AccountTo();

        accountTo.setAccountId( accountDetails.getAccountId() );
        accountTo.setAccountName( accountDetails.getAccountName() );
        accountTo.setAccountType( accountDetails.getAccountType() );

        return accountTo;
    }

    protected inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.AdditionalData additionalDataToAdditionalData(AdditionalData additionalData) {
        if ( additionalData == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.AdditionalData additionalData1 = new inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.AdditionalData();

        additionalData1.setType( additionalData.getType() );
        additionalData1.setValue( additionalData.getValue() );

        return additionalData1;
    }

    protected List<inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.AdditionalData> additionalDataListToAdditionalDataList(List<AdditionalData> list) {
        if ( list == null ) {
            return null;
        }

        List<inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.AdditionalData> list1 = new ArrayList<inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.AdditionalData>( list.size() );
        for ( AdditionalData additionalData : list ) {
            list1.add( additionalDataToAdditionalData( additionalData ) );
        }

        return list1;
    }

    protected inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.TransactionAmounts transactionAmountsToTransactionAmounts(TransactionAmounts transactionAmounts) {
        if ( transactionAmounts == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.TransactionAmounts transactionAmounts1 = new inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.TransactionAmounts();

        transactionAmounts1.setAmountQualifier( transactionAmounts.getAmountQualifier() );
        transactionAmounts1.setTransactionAmount( transactionAmounts.getTransactionAmount() );
        transactionAmounts1.setTransactionCurrency( transactionAmounts.getTransactionCurrency() );

        return transactionAmounts1;
    }

    protected inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.TransactionIdentification transactionIdentificationToTransactionIdentification(TransactionIdentification transactionIdentification) {
        if ( transactionIdentification == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.TransactionIdentification transactionIdentification1 = new inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.TransactionIdentification();

        transactionIdentification1.setLocalDate( transactionIdentification.getLocalDate() );
        transactionIdentification1.setRetrievalReferenceNumber( transactionIdentification.getRetrievalReferenceNumber() );
        transactionIdentification1.setSystemTraceAuditNumber( transactionIdentification.getSystemTraceAuditNumber() );

        return transactionIdentification1;
    }

    protected Transaction transactionToTransaction(inc.nimbuspay.commonobjectmodel.transaction.Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        Transaction transaction1 = new Transaction();

        transaction1.setAccountFrom( accountDetailsToAccountFrom( transaction.getAcctFrom() ) );
        transaction1.setAccountTo( accountDetailsToAccountTo( transaction.getAcctTo() ) );
        transaction1.setAdditionalData( additionalDataListToAdditionalDataList( transaction.getAdditionalData() ) );
        List<String> list1 = transaction.getAlternateMessageReason();
        if ( list1 != null ) {
            transaction1.setAlternateMessageReason( new ArrayList<String>( list1 ) );
        }
        transaction1.setAssociatedDataDestination( transaction.getAssociatedDataDestination() );
        transaction1.setAssociatedDataIndicator( transaction.getAssociatedDataIndicator() );
        transaction1.setAssociatedDataReference( transaction.getAssociatedDataReference() );
        List<String> list2 = transaction.getMessageReason();
        if ( list2 != null ) {
            transaction1.setMessageReason( new ArrayList<String>( list2 ) );
        }
        transaction1.setOtherTransactionAttribute( transaction.getOtherTransactionAttribute() );
        transaction1.setPreAuthorisationTimeLimit( transaction.getPreAuthorisationTimeLimit() );
        transaction1.setTransactionAmounts( transactionAmountsToTransactionAmounts( transaction.getTransactionAmounts() ) );
        transaction1.setTransactionAttribute( transaction.getTransactionAttribute() );
        transaction1.setTransactionDescription( transaction.getTransactionDescription() );
        transaction1.setTransactionIdentification( transactionIdentificationToTransactionIdentification( transaction.getTransactionIdentification() ) );
        transaction1.setTransactionSubType( transaction.getTransactionSubType() );
        transaction1.setTransactionType( transaction.getTransactionType() );

        return transaction1;
    }

    private Acquirer acquirerToIssuerCardTransactionsModelEnvironmentAcquirer(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return null;
        }
        Environment environment = acquirerToIssuerCardTransactionsModel.getEnvironment();
        if ( environment == null ) {
            return null;
        }
        Acquirer acquirer = environment.getAcquirer();
        if ( acquirer == null ) {
            return null;
        }
        return acquirer;
    }

    protected inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.LocalData localDataToLocalData(LocalData localData) {
        if ( localData == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.LocalData localData1 = new inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.LocalData();

        localData1.setAdditionalData( additionalDataListToAdditionalDataList( localData.getAdditionalData() ) );
        localData1.setLegalCorporateName( localData.getLegalCorporateName() );
        localData1.setShortName( localData.getShortName() );

        return localData1;
    }

    protected inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Acquirer acquirerToAcquirer(Acquirer acquirer) {
        if ( acquirer == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Acquirer acquirer1 = new inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Acquirer();

        acquirer1.setAdditionalIdentification( additionalDataToAdditionalData( acquirer.getAdditionalIdentification() ) );
        acquirer1.setAssigner( acquirer.getAssigner() );
        acquirer1.setCountry( acquirer.getCountry() );
        acquirer1.setIdentification( acquirer.getIdentification() );
        acquirer1.setLegalCorporateName( acquirer.getLegalCorporateName() );
        acquirer1.setLocalData( localDataToLocalData( acquirer.getLocalData() ) );
        acquirer1.setShortName( acquirer.getShortName() );

        return acquirer1;
    }

    private Issuer acquirerToIssuerCardTransactionsModelEnvironmentIssuer(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return null;
        }
        Environment environment = acquirerToIssuerCardTransactionsModel.getEnvironment();
        if ( environment == null ) {
            return null;
        }
        Issuer issuer = environment.getIssuer();
        if ( issuer == null ) {
            return null;
        }
        return issuer;
    }

    protected inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Issuer issuerToIssuer(Issuer issuer) {
        if ( issuer == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Issuer issuer1 = new inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Issuer();

        issuer1.setAdditionalIdentification( additionalDataToAdditionalData( issuer.getAdditionalIdentification() ) );
        issuer1.setAssigner( issuer.getAssigner() );
        issuer1.setCountry( issuer.getCountry() );
        issuer1.setIdentification( issuer.getIdentification() );
        issuer1.setLegalCorporateName( issuer.getLegalCorporateName() );
        issuer1.setLocalData( localDataToLocalData( issuer.getLocalData() ) );
        issuer1.setShortName( issuer.getShortName() );

        return issuer1;
    }

    private Card acquirerToIssuerCardTransactionsModelEnvironmentCard(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return null;
        }
        Environment environment = acquirerToIssuerCardTransactionsModel.getEnvironment();
        if ( environment == null ) {
            return null;
        }
        Card card = environment.getCard();
        if ( card == null ) {
            return null;
        }
        return card;
    }

    protected inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Card cardToCard(Card card) {
        if ( card == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Card card1 = new inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.Card();

        card1.setAdditionalCardData( additionalDataListToAdditionalDataList( card.getAdditionalCardData() ) );
        card1.setCardPortfolioIdentifier( card.getCardPortfolioIdentifier() );
        card1.setCardSequenceNumber( card.getCardSequenceNumber() );
        card1.setPanAccountRange( card.getPanAccountRange() );
        card1.setPaymentAccountReference( card.getPaymentAccountReference() );
        card1.setPrimaryAccountNumber( card.getPrimaryAccountNumber() );
        card1.setProtectedPANIndicator( card.getProtectedPANIndicator() );

        return card1;
    }

    protected inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.InitiatingParty initiatingPartyToInitiatingParty(InitiatingParty initiatingParty) {
        if ( initiatingParty == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.InitiatingParty initiatingParty1 = new inc.nimbuspay.proaccountrest.transaction.entity.objectmodel.InitiatingParty();

        initiatingParty1.setAssigner( initiatingParty.getAssigner() );
        initiatingParty1.setCountry( initiatingParty.getCountry() );
        initiatingParty1.setIdentification( initiatingParty.getIdentification() );
        initiatingParty1.setOtherType( initiatingParty.getOtherType() );
        initiatingParty1.setShortName( initiatingParty.getShortName() );
        initiatingParty1.setType( initiatingParty.getType() );

        return initiatingParty1;
    }
}
