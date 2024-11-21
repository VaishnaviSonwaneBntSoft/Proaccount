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
import inc.nimbuspay.commonobjectmodel.result.ProcessingResult;
import inc.nimbuspay.commonobjectmodel.result.ResultData;
import inc.nimbuspay.commonobjectmodel.transaction.AccountDetails;
import inc.nimbuspay.commonobjectmodel.transaction.Card;
import inc.nimbuspay.commonobjectmodel.transaction.Transaction;
import inc.nimbuspay.commonobjectmodel.transaction.TransactionAmounts;
import inc.nimbuspay.commonobjectmodel.transaction.TransactionIdentification;
import inc.nimbuspay.proaccountrest.transaction.request.FinancialInitiation;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.AccountDetails3;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.AdditionalData1;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.CardData6;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.Context10;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.Environment17;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.FinancialInitiation2;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.FinancialInitiationV03;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.GenericIdentification183;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.Header62;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.LocalData1;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.PartyIdentification263;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.PointOfServiceContext3;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.Transaction145;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.TransactionAmount1;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.TransactionAmounts2;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.TransactionContext7;
import inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.TransactionIdentification16;
import inc.nimbuspay.proaccountrest.transaction.response.FinancialResponse;
import inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.Environment26;
import inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.FinancialResponse2;
import inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.FinancialResponseV03;
import inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.MessageFunction16Code;
import inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.PartyType17Code;
import inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.PartyType18Code;
import inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.ProcessingResult10;
import inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.ResultData7;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-30T10:08:53+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class AcquirerToIssuerCardTransactionsMapperImpl implements AcquirerToIssuerCardTransactionsMapper {

    @Override
    public AcquirerToIssuerCardTransactionsModel financialInitiationToAcquirerToIssuerCardTransactionsModel(FinancialInitiation finInitn) {
        if ( finInitn == null ) {
            return null;
        }

        AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel = new AcquirerToIssuerCardTransactionsModel();

        inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.MessageFunction16Code msgFctn = finInitnFinInitnHdrMsgFctn( finInitn );
        if ( msgFctn != null ) {
            acquirerToIssuerCardTransactionsModel.setMessageFunction( msgFctn.name() );
        }
        acquirerToIssuerCardTransactionsModel.setProtocolVersion( finInitnFinInitnHdrPrtcolVrsn( finInitn ) );
        acquirerToIssuerCardTransactionsModel.setCreationDateTime( finInitnFinInitnHdrCreDtTm( finInitn ) );
        acquirerToIssuerCardTransactionsModel.setInitiatingParty( mapInitiatingParty( finInitnFinInitnHdrInitgPty( finInitn ) ) );
        acquirerToIssuerCardTransactionsModel.setEnvironment( mapEnvironment( finInitnFinInitnBodyEnvt( finInitn ) ) );
        acquirerToIssuerCardTransactionsModel.setContext( mapContext( finInitnFinInitnBodyCntxt( finInitn ) ) );
        acquirerToIssuerCardTransactionsModel.setTransaction( mapTransaction( finInitnFinInitnBodyTx( finInitn ) ) );

        return acquirerToIssuerCardTransactionsModel;
    }

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
    public Environment mapEnvironment(Environment17 envt) {
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
    public Card mapCard(CardData6 card) {
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
    public Context mapContext(Context10 cntxt) {
        if ( cntxt == null ) {
            return null;
        }

        Context context = new Context();

        context.setPointOfServiceContext( pointOfServiceContext3ToPointOfServiceContext( cntxt.getPtOfSvcCntxt() ) );
        context.setTransactionContext( transactionContext7ToTransactionContext( cntxt.getTxCntxt() ) );

        return context;
    }

    @Override
    public Transaction mapTransaction(Transaction145 tx) {
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
        transaction.setTransactionIdentification( transactionIdentification16ToTransactionIdentification( tx.getTxId() ) );
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
    public FinancialResponse acquirerToIssuerCardTransactionsModelTofinancialResponse(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return null;
        }

        FinancialResponse financialResponse = new FinancialResponse();

        if ( acquirerToIssuerCardTransactionsModel.getInitiatingParty() != null ) {
            if ( financialResponse.getFinRspn() == null ) {
                financialResponse.setFinRspn( FinancialResponseV03.builder().build() );
            }
            initiatingPartyToFinancialResponseV03( acquirerToIssuerCardTransactionsModel.getInitiatingParty(), financialResponse.getFinRspn() );
        }
        if ( financialResponse.getFinRspn() == null ) {
            financialResponse.setFinRspn( FinancialResponseV03.builder().build() );
        }
        acquirerToIssuerCardTransactionsModelToFinancialResponseV03( acquirerToIssuerCardTransactionsModel, financialResponse.getFinRspn() );

        return financialResponse;
    }

    @Override
    public Environment26 mapEnvironment(Environment environment) {
        if ( environment == null ) {
            return null;
        }

        Environment26.Environment26Builder environment26 = Environment26.builder();

        environment26.acqrr( mapAcquirer( environment.getAcquirer() ) );
        environment26.issr( mapIssuer( environment.getIssuer() ) );

        return environment26.build();
    }

    @Override
    public inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.PartyIdentification263 mapAcquirer(Acquirer acqrr) {
        if ( acqrr == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.PartyIdentification263.PartyIdentification263Builder partyIdentification263 = inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.PartyIdentification263.builder();

        partyIdentification263.id( acqrr.getIdentification() );
        partyIdentification263.assgnr( acqrr.getAssigner() );
        partyIdentification263.ctry( acqrr.getCountry() );
        partyIdentification263.shrtNm( acqrr.getShortName() );
        partyIdentification263.lglCorpNm( acqrr.getLegalCorporateName() );
        partyIdentification263.addtlId( additionalDataToAdditionalData1( acqrr.getAdditionalIdentification() ) );
        partyIdentification263.lclData( localDataToLocalData1( acqrr.getLocalData() ) );

        return partyIdentification263.build();
    }

    @Override
    public inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.PartyIdentification263 mapIssuer(Issuer issuer) {
        if ( issuer == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.PartyIdentification263.PartyIdentification263Builder partyIdentification263 = inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.PartyIdentification263.builder();

        partyIdentification263.id( issuer.getIdentification() );
        partyIdentification263.assgnr( issuer.getAssigner() );
        partyIdentification263.ctry( issuer.getCountry() );
        partyIdentification263.shrtNm( issuer.getShortName() );
        partyIdentification263.lglCorpNm( issuer.getLegalCorporateName() );
        partyIdentification263.addtlId( additionalDataToAdditionalData1( issuer.getAdditionalIdentification() ) );
        partyIdentification263.lclData( localDataToLocalData1( issuer.getLocalData() ) );

        return partyIdentification263.build();
    }

    @Override
    public ProcessingResult10 mapProcessingResult(ProcessingResult processingResult) {
        if ( processingResult == null ) {
            return null;
        }

        ProcessingResult10.ProcessingResult10Builder processingResult10 = ProcessingResult10.builder();

        processingResult10.rsltData( mapResultData( processingResult.getResultData() ) );

        return processingResult10.build();
    }

    @Override
    public ResultData7 mapResultData(ResultData resultData) {
        if ( resultData == null ) {
            return null;
        }

        ResultData7.ResultData7Builder resultData7 = ResultData7.builder();

        resultData7.rsltDtls( resultData.getResultDetails() );

        return resultData7.build();
    }

    private inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.MessageFunction16Code finInitnFinInitnHdrMsgFctn(FinancialInitiation financialInitiation) {
        if ( financialInitiation == null ) {
            return null;
        }
        FinancialInitiationV03 finInitn = financialInitiation.getFinInitn();
        if ( finInitn == null ) {
            return null;
        }
        Header62 hdr = finInitn.getHdr();
        if ( hdr == null ) {
            return null;
        }
        inc.nimbuspay.proaccountrest.transaction.request.generated.financialinitiationv03.MessageFunction16Code msgFctn = hdr.getMsgFctn();
        if ( msgFctn == null ) {
            return null;
        }
        return msgFctn;
    }

    private String finInitnFinInitnHdrPrtcolVrsn(FinancialInitiation financialInitiation) {
        if ( financialInitiation == null ) {
            return null;
        }
        FinancialInitiationV03 finInitn = financialInitiation.getFinInitn();
        if ( finInitn == null ) {
            return null;
        }
        Header62 hdr = finInitn.getHdr();
        if ( hdr == null ) {
            return null;
        }
        String prtcolVrsn = hdr.getPrtcolVrsn();
        if ( prtcolVrsn == null ) {
            return null;
        }
        return prtcolVrsn;
    }

    private String finInitnFinInitnHdrCreDtTm(FinancialInitiation financialInitiation) {
        if ( financialInitiation == null ) {
            return null;
        }
        FinancialInitiationV03 finInitn = financialInitiation.getFinInitn();
        if ( finInitn == null ) {
            return null;
        }
        Header62 hdr = finInitn.getHdr();
        if ( hdr == null ) {
            return null;
        }
        String creDtTm = hdr.getCreDtTm();
        if ( creDtTm == null ) {
            return null;
        }
        return creDtTm;
    }

    private GenericIdentification183 finInitnFinInitnHdrInitgPty(FinancialInitiation financialInitiation) {
        if ( financialInitiation == null ) {
            return null;
        }
        FinancialInitiationV03 finInitn = financialInitiation.getFinInitn();
        if ( finInitn == null ) {
            return null;
        }
        Header62 hdr = finInitn.getHdr();
        if ( hdr == null ) {
            return null;
        }
        GenericIdentification183 initgPty = hdr.getInitgPty();
        if ( initgPty == null ) {
            return null;
        }
        return initgPty;
    }

    private Environment17 finInitnFinInitnBodyEnvt(FinancialInitiation financialInitiation) {
        if ( financialInitiation == null ) {
            return null;
        }
        FinancialInitiationV03 finInitn = financialInitiation.getFinInitn();
        if ( finInitn == null ) {
            return null;
        }
        FinancialInitiation2 body = finInitn.getBody();
        if ( body == null ) {
            return null;
        }
        Environment17 envt = body.getEnvt();
        if ( envt == null ) {
            return null;
        }
        return envt;
    }

    private Context10 finInitnFinInitnBodyCntxt(FinancialInitiation financialInitiation) {
        if ( financialInitiation == null ) {
            return null;
        }
        FinancialInitiationV03 finInitn = financialInitiation.getFinInitn();
        if ( finInitn == null ) {
            return null;
        }
        FinancialInitiation2 body = finInitn.getBody();
        if ( body == null ) {
            return null;
        }
        Context10 cntxt = body.getCntxt();
        if ( cntxt == null ) {
            return null;
        }
        return cntxt;
    }

    private Transaction145 finInitnFinInitnBodyTx(FinancialInitiation financialInitiation) {
        if ( financialInitiation == null ) {
            return null;
        }
        FinancialInitiationV03 finInitn = financialInitiation.getFinInitn();
        if ( finInitn == null ) {
            return null;
        }
        FinancialInitiation2 body = finInitn.getBody();
        if ( body == null ) {
            return null;
        }
        Transaction145 tx = body.getTx();
        if ( tx == null ) {
            return null;
        }
        return tx;
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

    protected PointOfServiceContext pointOfServiceContext3ToPointOfServiceContext(PointOfServiceContext3 pointOfServiceContext3) {
        if ( pointOfServiceContext3 == null ) {
            return null;
        }

        PointOfServiceContext pointOfServiceContext = new PointOfServiceContext();

        if ( pointOfServiceContext3.getCardDataNtryMd() != null ) {
            pointOfServiceContext.setCardDataEntryMode( pointOfServiceContext3.getCardDataNtryMd().name() );
        }

        return pointOfServiceContext;
    }

    protected TransactionContext transactionContext7ToTransactionContext(TransactionContext7 transactionContext7) {
        if ( transactionContext7 == null ) {
            return null;
        }

        TransactionContext transactionContext = new TransactionContext();

        if ( transactionContext7.getMrchntCtgyCd() != null ) {
            transactionContext.setMerchantCategoryCode( Integer.parseInt( transactionContext7.getMrchntCtgyCd() ) );
        }

        return transactionContext;
    }

    protected TransactionIdentification transactionIdentification16ToTransactionIdentification(TransactionIdentification16 transactionIdentification16) {
        if ( transactionIdentification16 == null ) {
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

    protected void initiatingPartyToGenericIdentification183(InitiatingParty initiatingParty, inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.GenericIdentification183 mappingTarget) {
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

    protected void initiatingPartyToHeader62(InitiatingParty initiatingParty, inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.Header62 mappingTarget) {
        if ( initiatingParty == null ) {
            return;
        }

        if ( mappingTarget.getInitgPty() == null ) {
            mappingTarget.setInitgPty( inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.GenericIdentification183.builder().build() );
        }
        initiatingPartyToGenericIdentification183( initiatingParty, mappingTarget.getInitgPty() );
    }

    protected void initiatingPartyToFinancialResponseV03(InitiatingParty initiatingParty, FinancialResponseV03 mappingTarget) {
        if ( initiatingParty == null ) {
            return;
        }

        if ( mappingTarget.getHdr() == null ) {
            mappingTarget.setHdr( inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.Header62.builder().build() );
        }
        initiatingPartyToHeader62( initiatingParty, mappingTarget.getHdr() );
    }

    protected void acquirerToIssuerCardTransactionsModelToHeader62(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel, inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.Header62 mappingTarget) {
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

    protected void acquirerToIssuerCardTransactionsModelToFinancialResponse2(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel, FinancialResponse2 mappingTarget) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return;
        }

        mappingTarget.setEnvt( mapEnvironment( acquirerToIssuerCardTransactionsModel.getEnvironment() ) );
        mappingTarget.setPrcgRslt( mapProcessingResult( acquirerToIssuerCardTransactionsModel.getProcessingResult() ) );
    }

    protected void acquirerToIssuerCardTransactionsModelToFinancialResponseV03(AcquirerToIssuerCardTransactionsModel acquirerToIssuerCardTransactionsModel, FinancialResponseV03 mappingTarget) {
        if ( acquirerToIssuerCardTransactionsModel == null ) {
            return;
        }

        if ( mappingTarget.getHdr() == null ) {
            mappingTarget.setHdr( inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.Header62.builder().build() );
        }
        acquirerToIssuerCardTransactionsModelToHeader62( acquirerToIssuerCardTransactionsModel, mappingTarget.getHdr() );
        if ( mappingTarget.getBody() == null ) {
            mappingTarget.setBody( FinancialResponse2.builder().build() );
        }
        acquirerToIssuerCardTransactionsModelToFinancialResponse2( acquirerToIssuerCardTransactionsModel, mappingTarget.getBody() );
    }

    protected inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.AdditionalData1 additionalDataToAdditionalData1(AdditionalData additionalData) {
        if ( additionalData == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.AdditionalData1.AdditionalData1Builder additionalData1 = inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.AdditionalData1.builder();

        return additionalData1.build();
    }

    protected inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.LocalData1 localDataToLocalData1(LocalData localData) {
        if ( localData == null ) {
            return null;
        }

        inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.LocalData1.LocalData1Builder localData1 = inc.nimbuspay.proaccountrest.transaction.response.generated.financialresponsev03.LocalData1.builder();

        return localData1.build();
    }
}
