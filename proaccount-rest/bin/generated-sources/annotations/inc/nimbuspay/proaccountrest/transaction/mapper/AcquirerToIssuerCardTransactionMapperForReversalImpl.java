package inc.nimbuspay.proaccountrest.transaction.mapper;

import inc.nimbuspay.commonobjectmodel.context.Context;
import inc.nimbuspay.commonobjectmodel.context.PointOfServiceContext;
import inc.nimbuspay.commonobjectmodel.context.TransactionContext;
import inc.nimbuspay.commonobjectmodel.environment.Environment;
import inc.nimbuspay.commonobjectmodel.general.AdditionalData;
import inc.nimbuspay.commonobjectmodel.general.LocalData;
import inc.nimbuspay.commonobjectmodel.model.acquirertoissuercardmessages.AcquirerToIssuerCardTransactionsModel;
import inc.nimbuspay.commonobjectmodel.party.Acquirer;
import inc.nimbuspay.commonobjectmodel.party.InitiatingParty;
import inc.nimbuspay.commonobjectmodel.party.Issuer;
import inc.nimbuspay.commonobjectmodel.transaction.AccountDetails;
import inc.nimbuspay.commonobjectmodel.transaction.Card;
import inc.nimbuspay.commonobjectmodel.transaction.Transaction;
import inc.nimbuspay.commonobjectmodel.transaction.TransactionAmounts;
import inc.nimbuspay.commonobjectmodel.transaction.TransactionIdentification;
import inc.nimbuspay.proaccountrest.transaction.request.ReversalInitiation;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.AccountDetails3;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.AdditionalData1;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.CardData10;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.Context14;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.Environment19;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.GenericIdentification183;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.Header62;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.LocalData1;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.PartyIdentification263;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.PointOfServiceContext5;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.ReversalInitiation2;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.ReversalInitiationV03;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.Transaction142;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.TransactionAmount1;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.TransactionAmounts2;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.TransactionContext9;
import inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.TransactionIdentification51;
import inc.nimbuspay.proaccountrest.transaction.response.ReversalResponse;
import inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.Environment29;
import inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.MessageFunction16Code;
import inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.PartyType17Code;
import inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.PartyType18Code;
import inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.ReversalResponse4;
import inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.ReversalResponseV03;
import inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.Transaction137;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-30T10:08:54+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class AcquirerToIssuerCardTransactionMapperForReversalImpl implements AcquirerToIssuerCardTransactionMapperForReversal {

    @Override
    public InitiatingParty mapInitiatingParty(GenericIdentification183 initgPty) {
        if ( initgPty == null ) {
            return null;
        }

        InitiatingParty initiatingParty = new InitiatingParty();

        initiatingParty.setIdentification( initgPty.getId() );
        if ( initgPty.getTp() != null ) {
            initiatingParty.setType( initgPty.getTp().name() );
        }
        initiatingParty.setOtherType( initgPty.getOthrTp() );
        if ( initgPty.getAssgnr() != null ) {
            initiatingParty.setAssigner( initgPty.getAssgnr().name() );
        }
        initiatingParty.setCountry( initgPty.getCtry() );
        initiatingParty.setShortName( initgPty.getShrtNm() );

        return initiatingParty;
    }

    @Override
    public Environment mapEnvironment(Environment19 envt) {
        if ( envt == null ) {
            return null;
        }

        Environment environment = new Environment();

        environment.setAcquirer( mapAcquirer( envt.getAcqrr() ) );
        environment.setIssuer( mapIssuer( envt.getIssr() ) );
        environment.setCard( mapCard( envt.getCard() ) );

        return environment;
    }

    @Override
    public Acquirer mapAcquirer(PartyIdentification263 acqrr) {
        if ( acqrr == null ) {
            return null;
        }

        Acquirer acquirer = new Acquirer();

        acquirer.setIdentification( acqrr.getId() );
        acquirer.setAssigner( acqrr.getAssgnr() );
        acquirer.setCountry( acqrr.getCtry() );
        acquirer.setShortName( acqrr.getShrtNm() );
        acquirer.setLegalCorporateName( acqrr.getLglCorpNm() );
        acquirer.setAdditionalIdentification( mapAdditionalData( acqrr.getAddtlId() ) );
        acquirer.setLocalData( mapLocalData( acqrr.getLclData() ) );

        return acquirer;
    }

    @Override
    public Issuer mapIssuer(PartyIdentification263 issuer) {
        if ( issuer == null ) {
            return null;
        }

        Issuer issuer1 = new Issuer();

        issuer1.setIdentification( issuer.getId() );
        issuer1.setAssigner( issuer.getAssgnr() );
        issuer1.setCountry( issuer.getCtry() );
        issuer1.setShortName( issuer.getShrtNm() );
        issuer1.setLegalCorporateName( issuer.getLglCorpNm() );
        issuer1.setAdditionalIdentification( mapAdditionalData( issuer.getAddtlId() ) );
        issuer1.setLocalData( mapLocalData( issuer.getLclData() ) );

        return issuer1;
    }

    @Override
    public Card mapCard(CardData10 card) {
        if ( card == null ) {
            return null;
        }

        Card card1 = new Card();

        card1.setPrimaryAccountNumber( card.getPan() );
        card1.setProtectedPANIndicator( card.getPrtctdPANInd() );
        card1.setCardSequenceNumber( card.getCardSeqNb() );
        card1.setPaymentAccountReference( card.getPmtAcctRef() );
        card1.setPanAccountRange( card.getPanAcctRg() );
        card1.setCardPortfolioIdentifier( card.getCardPrtflIdr() );
        card1.setAdditionalCardData( additionalData1ListToAdditionalDataList( card.getAddtlCardData() ) );

        return card1;
    }

    @Override
    public Context mapContext(Context14 cntxt) {
        if ( cntxt == null ) {
            return null;
        }

        Context context = new Context();

        context.setPointOfServiceContext( pointOfServiceContext5ToPointOfServiceContext( cntxt.getPtOfSvcCntxt() ) );
        context.setTransactionContext( transactionContext9ToTransactionContext( cntxt.getTxCntxt() ) );

        return context;
    }

    @Override
    public Transaction mapTransaction(Transaction142 tx) {
        if ( tx == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setTransactionType( tx.getTxTp() );
        transaction.setTransactionSubType( tx.getTxSubTp() );
        if ( tx.getTxAttr() != null ) {
            transaction.setTransactionAttribute( tx.getTxAttr().name() );
        }
        transaction.setOtherTransactionAttribute( tx.getOthrTxAttr() );
        List<String> list = tx.getMsgRsn();
        if ( list != null ) {
            transaction.setMessageReason( new ArrayList<String>( list ) );
        }
        List<String> list1 = tx.getAltrnMsgRsn();
        if ( list1 != null ) {
            transaction.setAlternateMessageReason( new ArrayList<String>( list1 ) );
        }
        transaction.setPreAuthorisationTimeLimit( tx.getPreAuthstnTmLmt() );
        transaction.setAssociatedDataIndicator( tx.getAssoctdDataInd() );
        transaction.setAssociatedDataReference( tx.getAssoctdDataRef() );
        transaction.setAssociatedDataDestination( tx.getAssoctdDataDstn() );
        transaction.setAcctFrom( mapAccountDetails( tx.getAcctFr() ) );
        transaction.setAcctTo( mapAccountDetails( tx.getAcctTo() ) );
        transaction.setTransactionIdentification( transactionIdentification51ToTransactionIdentification( tx.getTxId() ) );
        transaction.setTransactionAmounts( mapTransactionAmounts( tx.getTxAmts() ) );
        transaction.setTransactionDescription( tx.getTxDesc() );
        transaction.setAdditionalData( additionalData1ListToAdditionalDataList( tx.getAddtlData() ) );

        return transaction;
    }

    @Override
    public AdditionalData mapAdditionalData(AdditionalData1 additionalData1) {
        if ( additionalData1 == null ) {
            return null;
        }

        AdditionalData additionalData = new AdditionalData();

        additionalData.setType( additionalData1.getTp() );
        additionalData.setValue( additionalData1.getVal() );

        return additionalData;
    }

    @Override
    public TransactionAmounts mapTransactionAmounts(TransactionAmounts2 transactionAmounts) {
        if ( transactionAmounts == null ) {
            return null;
        }

        TransactionAmounts transactionAmounts1 = new TransactionAmounts();

        BigDecimal amt = transactionAmountsTxAmtAmt( transactionAmounts );
        if ( amt != null ) {
            transactionAmounts1.setTransactionAmount( amt.toString() );
        }
        transactionAmounts1.setTransactionCurrency( transactionAmountsTxAmtCcy( transactionAmounts ) );

        return transactionAmounts1;
    }

    @Override
    public LocalData mapLocalData(LocalData1 lclData) {
        if ( lclData == null ) {
            return null;
        }

        LocalData localData = new LocalData();

        localData.setLanguage( lclData.getLang() );
        localData.setShortName( lclData.getShrtNm() );
        localData.setLegalCorporateName( lclData.getLglCorpNm() );
        localData.setAdditionalData( additionalData1ListToAdditionalDataList( lclData.getAddtlData() ) );

        return localData;
    }

    @Override
    public AccountDetails mapAccountDetails(AccountDetails3 accountDetails3) {
        if ( accountDetails3 == null ) {
            return null;
        }

        AccountDetails accountDetails = new AccountDetails();

        accountDetails.setAccountName( accountDetails3.getAcctNm() );
        accountDetails.setAccountType( accountDetails3.getAcctTp() );
        accountDetails.setAccountId( accountDetails3.getAcctId() );

        return accountDetails;
    }

    @Override
    public AcquirerToIssuerCardTransactionsModel reversalInitiationToAcquirerToIssuerCardTransactionsModel(ReversalInitiation riversalInitiation) {
        if ( riversalInitiation == null ) {
            return null;
        }

        AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel = new AcquirerToIssuerCardTransactionsModel();

        inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.MessageFunction16Code msgFctn = riversalInitiationRvslInitnHdrMsgFctn( riversalInitiation );
        if ( msgFctn != null ) {
            acquirerToIssuerCardTransactionsModel.setMessageFunction( msgFctn.name() );
        }
        acquirerToIssuerCardTransactionsModel.setProtocolVersion( riversalInitiationRvslInitnHdrPrtcolVrsn( riversalInitiation ) );
        acquirerToIssuerCardTransactionsModel.setCreationDateTime( riversalInitiationRvslInitnHdrCreDtTm( riversalInitiation ) );
        acquirerToIssuerCardTransactionsModel.setInitiatingParty( mapInitiatingParty( riversalInitiationRvslInitnHdrInitgPty( riversalInitiation ) ) );
        acquirerToIssuerCardTransactionsModel.setEnvironment( mapEnvironment( riversalInitiationRvslInitnBodyEnvt( riversalInitiation ) ) );
        acquirerToIssuerCardTransactionsModel.setContext( mapContext( riversalInitiationRvslInitnBodyCntxt( riversalInitiation ) ) );
        acquirerToIssuerCardTransactionsModel.setTransaction( mapTransaction( riversalInitiationRvslInitnBodyTx( riversalInitiation ) ) );

        return acquirerToIssuerCardTransactionsModel;
    }

    @Override
    public ReversalResponse acquirerToIssuerCardTransactionsModelToReversalResponse(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return null;
        }

        ReversalResponse reversalResponse = new ReversalResponse();

        if ( acquirerToIssuerCardTransactionsModel.getInitiatingParty() != null ) {
            if ( reversalResponse.getReversalRspn() == null ) {
                reversalResponse.setReversalRspn( ReversalResponseV03.builder().build() );
            }
            initiatingPartyToReversalResponseV03( acquirerToIssuerCardTransactionsModel.getInitiatingParty(), reversalResponse.getReversalRspn() );
        }
        if ( acquirerToIssuerCardTransactionsModel.getEnvironment() != null ) {
            if ( reversalResponse.getReversalRspn() == null ) {
                reversalResponse.setReversalRspn( ReversalResponseV03.builder().build() );
            }
            environmentToReversalResponseV03( acquirerToIssuerCardTransactionsModel.getEnvironment(), reversalResponse.getReversalRspn() );
        }
        if ( acquirerToIssuerCardTransactionsModel.getTransaction() != null ) {
            if ( reversalResponse.getReversalRspn() == null ) {
                reversalResponse.setReversalRspn( ReversalResponseV03.builder().build() );
            }
            transactionToReversalResponseV03( acquirerToIssuerCardTransactionsModel.getTransaction(), reversalResponse.getReversalRspn() );
        }
        if ( reversalResponse.getReversalRspn() == null ) {
            reversalResponse.setReversalRspn( ReversalResponseV03.builder().build() );
        }
        acquirerToIssuerCardTransactionsModelToReversalResponseV03( acquirerToIssuerCardTransactionsModel, reversalResponse.getReversalRspn() );

        return reversalResponse;
    }

    protected List<AdditionalData> additionalData1ListToAdditionalDataList(List<AdditionalData1> list) {
        if ( list == null ) {
            return null;
        }

        List<AdditionalData> list1 = new ArrayList<AdditionalData>( list.size() );
        for ( AdditionalData1 additionalData1 : list ) {
            list1.add( mapAdditionalData( additionalData1 ) );
        }

        return list1;
    }

    protected PointOfServiceContext pointOfServiceContext5ToPointOfServiceContext(PointOfServiceContext5 pointOfServiceContext5) {
        if ( pointOfServiceContext5 == null ) {
            return null;
        }

        PointOfServiceContext pointOfServiceContext = new PointOfServiceContext();

        if ( pointOfServiceContext5.getCardDataNtryMd() != null ) {
            pointOfServiceContext.setCardDataEntryMode( pointOfServiceContext5.getCardDataNtryMd().name() );
        }

        return pointOfServiceContext;
    }

    protected TransactionContext transactionContext9ToTransactionContext(TransactionContext9 transactionContext9) {
        if ( transactionContext9 == null ) {
            return null;
        }

        TransactionContext transactionContext = new TransactionContext();

        if ( transactionContext9.getMrchntCtgyCd() != null ) {
            transactionContext.setMerchantCategoryCode( Integer.parseInt( transactionContext9.getMrchntCtgyCd() ) );
        }

        return transactionContext;
    }

    protected TransactionIdentification transactionIdentification51ToTransactionIdentification(TransactionIdentification51 transactionIdentification51) {
        if ( transactionIdentification51 == null ) {
            return null;
        }

        TransactionIdentification transactionIdentification = new TransactionIdentification();

        return transactionIdentification;
    }

    private BigDecimal transactionAmountsTxAmtAmt(TransactionAmounts2 transactionAmounts2) {
        if ( transactionAmounts2 == null ) {
            return null;
        }
        TransactionAmount1 txAmt = transactionAmounts2.getTxAmt();
        if ( txAmt == null ) {
            return null;
        }
        BigDecimal amt = txAmt.getAmt();
        if ( amt == null ) {
            return null;
        }
        return amt;
    }

    private String transactionAmountsTxAmtCcy(TransactionAmounts2 transactionAmounts2) {
        if ( transactionAmounts2 == null ) {
            return null;
        }
        TransactionAmount1 txAmt = transactionAmounts2.getTxAmt();
        if ( txAmt == null ) {
            return null;
        }
        String ccy = txAmt.getCcy();
        if ( ccy == null ) {
            return null;
        }
        return ccy;
    }

    private inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.MessageFunction16Code riversalInitiationRvslInitnHdrMsgFctn(ReversalInitiation reversalInitiation) {
        if ( reversalInitiation == null ) {
            return null;
        }
        ReversalInitiationV03 rvslInitn = reversalInitiation.getRvslInitn();
        if ( rvslInitn == null ) {
            return null;
        }
        Header62 hdr = rvslInitn.getHdr();
        if ( hdr == null ) {
            return null;
        }
        inc.nimbuspay.proaccountrest.transaction.request.generated.reversalinitiationv03.MessageFunction16Code msgFctn = hdr.getMsgFctn();
        if ( msgFctn == null ) {
            return null;
        }
        return msgFctn;
    }

    private String riversalInitiationRvslInitnHdrPrtcolVrsn(ReversalInitiation reversalInitiation) {
        if ( reversalInitiation == null ) {
            return null;
        }
        ReversalInitiationV03 rvslInitn = reversalInitiation.getRvslInitn();
        if ( rvslInitn == null ) {
            return null;
        }
        Header62 hdr = rvslInitn.getHdr();
        if ( hdr == null ) {
            return null;
        }
        String prtcolVrsn = hdr.getPrtcolVrsn();
        if ( prtcolVrsn == null ) {
            return null;
        }
        return prtcolVrsn;
    }

    private String riversalInitiationRvslInitnHdrCreDtTm(ReversalInitiation reversalInitiation) {
        if ( reversalInitiation == null ) {
            return null;
        }
        ReversalInitiationV03 rvslInitn = reversalInitiation.getRvslInitn();
        if ( rvslInitn == null ) {
            return null;
        }
        Header62 hdr = rvslInitn.getHdr();
        if ( hdr == null ) {
            return null;
        }
        String creDtTm = hdr.getCreDtTm();
        if ( creDtTm == null ) {
            return null;
        }
        return creDtTm;
    }

    private GenericIdentification183 riversalInitiationRvslInitnHdrInitgPty(ReversalInitiation reversalInitiation) {
        if ( reversalInitiation == null ) {
            return null;
        }
        ReversalInitiationV03 rvslInitn = reversalInitiation.getRvslInitn();
        if ( rvslInitn == null ) {
            return null;
        }
        Header62 hdr = rvslInitn.getHdr();
        if ( hdr == null ) {
            return null;
        }
        GenericIdentification183 initgPty = hdr.getInitgPty();
        if ( initgPty == null ) {
            return null;
        }
        return initgPty;
    }

    private Environment19 riversalInitiationRvslInitnBodyEnvt(ReversalInitiation reversalInitiation) {
        if ( reversalInitiation == null ) {
            return null;
        }
        ReversalInitiationV03 rvslInitn = reversalInitiation.getRvslInitn();
        if ( rvslInitn == null ) {
            return null;
        }
        ReversalInitiation2 body = rvslInitn.getBody();
        if ( body == null ) {
            return null;
        }
        Environment19 envt = body.getEnvt();
        if ( envt == null ) {
            return null;
        }
        return envt;
    }

    private Context14 riversalInitiationRvslInitnBodyCntxt(ReversalInitiation reversalInitiation) {
        if ( reversalInitiation == null ) {
            return null;
        }
        ReversalInitiationV03 rvslInitn = reversalInitiation.getRvslInitn();
        if ( rvslInitn == null ) {
            return null;
        }
        ReversalInitiation2 body = rvslInitn.getBody();
        if ( body == null ) {
            return null;
        }
        Context14 cntxt = body.getCntxt();
        if ( cntxt == null ) {
            return null;
        }
        return cntxt;
    }

    private Transaction142 riversalInitiationRvslInitnBodyTx(ReversalInitiation reversalInitiation) {
        if ( reversalInitiation == null ) {
            return null;
        }
        ReversalInitiationV03 rvslInitn = reversalInitiation.getRvslInitn();
        if ( rvslInitn == null ) {
            return null;
        }
        ReversalInitiation2 body = rvslInitn.getBody();
        if ( body == null ) {
            return null;
        }
        Transaction142 tx = body.getTx();
        if ( tx == null ) {
            return null;
        }
        return tx;
    }

    protected void initiatingPartyToGenericIdentification183(InitiatingParty initiatingParty, inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.GenericIdentification183 mappingTarget) {
        if ( initiatingParty == null ) {
            return;
        }

        mappingTarget.setId( initiatingParty.getIdentification() );
        if ( initiatingParty.getType() != null ) {
            mappingTarget.setTp( Enum.valueOf( PartyType17Code.class, initiatingParty.getType() ) );
        }
        else {
            mappingTarget.setTp( null );
        }
        mappingTarget.setOthrTp( initiatingParty.getOtherType() );
        if ( initiatingParty.getAssigner() != null ) {
            mappingTarget.setAssgnr( Enum.valueOf( PartyType18Code.class, initiatingParty.getAssigner() ) );
        }
        else {
            mappingTarget.setAssgnr( null );
        }
        mappingTarget.setCtry( initiatingParty.getCountry() );
        mappingTarget.setShrtNm( initiatingParty.getShortName() );
    }

    protected void initiatingPartyToHeader62(InitiatingParty initiatingParty, inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.Header62 mappingTarget) {
        if ( initiatingParty == null ) {
            return;
        }

        if ( mappingTarget.getInitgPty() == null ) {
            mappingTarget.setInitgPty( inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.GenericIdentification183.builder().build() );
        }
        initiatingPartyToGenericIdentification183( initiatingParty, mappingTarget.getInitgPty() );
    }

    protected void initiatingPartyToReversalResponseV03(InitiatingParty initiatingParty, ReversalResponseV03 mappingTarget) {
        if ( initiatingParty == null ) {
            return;
        }

        if ( mappingTarget.getHdr() == null ) {
            mappingTarget.setHdr( inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.Header62.builder().build() );
        }
        initiatingPartyToHeader62( initiatingParty, mappingTarget.getHdr() );
    }

    protected void acquirerToPartyIdentification263(Acquirer acquirer, inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.PartyIdentification263 mappingTarget) {
        if ( acquirer == null ) {
            return;
        }

        mappingTarget.setId( acquirer.getIdentification() );
        mappingTarget.setAssgnr( acquirer.getAssigner() );
        mappingTarget.setShrtNm( acquirer.getShortName() );
    }

    protected void acquirerToEnvironment29(Acquirer acquirer, Environment29 mappingTarget) {
        if ( acquirer == null ) {
            return;
        }

        if ( mappingTarget.getAcqrr() == null ) {
            mappingTarget.setAcqrr( inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.PartyIdentification263.builder().build() );
        }
        acquirerToPartyIdentification263( acquirer, mappingTarget.getAcqrr() );
    }

    protected void acquirerToReversalResponse4(Acquirer acquirer, ReversalResponse4 mappingTarget) {
        if ( acquirer == null ) {
            return;
        }

        if ( mappingTarget.getEnvt() == null ) {
            mappingTarget.setEnvt( Environment29.builder().build() );
        }
        acquirerToEnvironment29( acquirer, mappingTarget.getEnvt() );
    }

    protected void environmentToReversalResponseV03(Environment environment, ReversalResponseV03 mappingTarget) {
        if ( environment == null ) {
            return;
        }

        if ( environment.getAcquirer() != null ) {
            if ( mappingTarget.getBody() == null ) {
                mappingTarget.setBody( ReversalResponse4.builder().build() );
            }
            acquirerToReversalResponse4( environment.getAcquirer(), mappingTarget.getBody() );
        }
        else {
            mappingTarget.setBody( null );
        }
    }

    protected void transactionToTransaction137(Transaction transaction, Transaction137 mappingTarget) {
        if ( transaction == null ) {
            return;
        }

        mappingTarget.setTxTp( transaction.getTransactionType() );
    }

    protected void transactionToReversalResponse4(Transaction transaction, ReversalResponse4 mappingTarget) {
        if ( transaction == null ) {
            return;
        }

        if ( mappingTarget.getTx() == null ) {
            mappingTarget.setTx( Transaction137.builder().build() );
        }
        transactionToTransaction137( transaction, mappingTarget.getTx() );
    }

    protected void transactionToReversalResponseV03(Transaction transaction, ReversalResponseV03 mappingTarget) {
        if ( transaction == null ) {
            return;
        }

        if ( mappingTarget.getBody() == null ) {
            mappingTarget.setBody( ReversalResponse4.builder().build() );
        }
        transactionToReversalResponse4( transaction, mappingTarget.getBody() );
    }

    protected void acquirerToIssuerCardTransactionsModelToHeader62(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel, inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.Header62 mappingTarget) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return;
        }

        if ( acquirerToIssuerCardTransactionsModel.getMessageFunction() != null ) {
            mappingTarget.setMsgFctn( Enum.valueOf( MessageFunction16Code.class, acquirerToIssuerCardTransactionsModel.getMessageFunction() ) );
        }
        else {
            mappingTarget.setMsgFctn( null );
        }
        mappingTarget.setPrtcolVrsn( acquirerToIssuerCardTransactionsModel.getProtocolVersion() );
        mappingTarget.setXchgId( acquirerToIssuerCardTransactionsModel.getExchangeIdentification() );
        mappingTarget.setReTrnsmssnCntr( acquirerToIssuerCardTransactionsModel.getReTransmissionCounter() );
        mappingTarget.setCreDtTm( acquirerToIssuerCardTransactionsModel.getCreationDateTime() );
    }

    protected void acquirerToIssuerCardTransactionsModelToReversalResponseV03(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel, ReversalResponseV03 mappingTarget) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return;
        }

        if ( mappingTarget.getHdr() == null ) {
            mappingTarget.setHdr( inc.nimbuspay.proaccountrest.transaction.response.generated.reversalresponsev03.Header62.builder().build() );
        }
        acquirerToIssuerCardTransactionsModelToHeader62( acquirerToIssuerCardTransactionsModel, mappingTarget.getHdr() );
    }
}
