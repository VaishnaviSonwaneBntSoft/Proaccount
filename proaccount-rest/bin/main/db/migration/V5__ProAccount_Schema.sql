
CREATE TABLE proaccount.account (
    account_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    timestmp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    account_number BIGINT NOT NULL UNIQUE,
    account_owner BIGINT NOT NULL,
    account_type VARCHAR(26),
    iso4217_currency VARCHAR(3),
    product VARCHAR(40) NOT NULL,
    ledger_balance numeric(10, 2)  DEFAULT 0,
	deleted bool NOT NULL DEFAULT false,
    FOREIGN KEY (product) REFERENCES proshared.product(product_name),
    FOREIGN KEY (account_owner) REFERENCES procustomer.core_identity(customer_number)
);

CREATE TABLE proaccount.transaction_log (
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    request_type varchar(20) NULL,
    response_body text NULL,
    timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    internal_object_model text NULL,
    acquirer varchar(255) NULL,
    card_primary_account_number varchar(255) NULL,
    transaction_type varchar(255) NULL,
    transaction_amount varchar(255) NULL,
    transaction_currency varchar(255) NULL,
    account_from varchar(255) NULL,
    account_to varchar(255) NULL,
    transaction_status varchar(30),
    CONSTRAINT transaction_log_pkey PRIMARY KEY (id)
);

CREATE TABLE proaccount.ledger (
    ledger_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    timestmp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    transaction_type VARCHAR(16),
    transaction_value numeric(10, 2) NOT NULL,
    iso4217_currency VARCHAR(3),
    debit_account BIGINT NOT NULL,
    credit_account BIGINT NOT NULL,
    FOREIGN KEY (debit_account) REFERENCES proaccount.account(account_number),
    FOREIGN KEY (credit_account) REFERENCES proaccount.account(account_number)
);

CREATE TABLE proaccount.payment_reference (
	payment_reference_id uuid NOT NULL DEFAULT uuid_generate_v4(),
	payment_reference_number varchar(16) NOT NULL,
	account_number BIGINT NOT NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT payment_reference_number_unique UNIQUE (payment_reference_number),
	CONSTRAINT payment_reference_account_number_fkey FOREIGN KEY (account_number) REFERENCES proaccount.account(account_number)
);


 CREATE TABLE proaccount.acct_receivables_log (
    acct_rec_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    timestmp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    transaction_type VARCHAR(16),
    transaction_value numeric(10, 2) NOT NULL,
    iso4217_currency VARCHAR(3),
    source_account_number BIGINT NOT NULL,
    source_account_srt_cde VARCHAR(10),
    source_acc_iban VARCHAR(30),
    source_account_name VARCHAR(16) NOT NULL,
	transaction_source varchar(16) NOT NULL,
    destination_account BIGINT NOT NULL,
	pay_ref varchar(16) NOT NULL,
    FOREIGN KEY (destination_account) REFERENCES proaccount.account(account_number),
	CONSTRAINT acct_receivables_log_pay_ref_fkey FOREIGN KEY (pay_ref) REFERENCES proaccount.payment_reference(payment_reference_number)
);

CREATE TABLE proaccount.acct_payable_log (
    acct_pay_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    timestmp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    transaction_type VARCHAR(16),
    transaction_value numeric(10, 2) NOT NULL,
    iso4217_currency VARCHAR(3),
    dest_account_number BIGINT NOT NULL,
    dest_account_srt_cde VARCHAR(10),
    dest_acc_iban VARCHAR(30),
    dest_account_name VARCHAR(16) NOT NULL,
    source_acc BIGINT NOT NULL,
	transaction_source varchar(16) NOT NULL,
	pay_ref varchar(16) NOT NULL,
    FOREIGN KEY (source_acc) REFERENCES proaccount.account(account_number),
	CONSTRAINT acct_payables_log_pay_ref_fkey FOREIGN KEY (pay_ref) REFERENCES proaccount.payment_reference(payment_reference_number)
);

CREATE TABLE proaccount.pending_transactions (
    pending_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    timestmp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    account_number BIGINT NOT NULL,
    transaction_value numeric(10, 2) NOT NULL,
    iso4217_currency VARCHAR(3),
    FOREIGN KEY (account_number) REFERENCES proaccount.account(account_number)
);

CREATE TABLE proaccount.fraud_label (
    fraud_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    timestmp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    transaction_id UUID NOT NULL,
    third_party_fraud BOOLEAN,
    first_party_fraud BOOLEAN,
    FOREIGN KEY (transaction_id) REFERENCES proaccount.transaction_log(id)
);

CREATE TABLE proaccount.processing_result (
    id UUID NOT NULL,
    status VARCHAR(20) NULL,
    timestmp TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE proaccount.transaction_amounts (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	amount_qualifier varchar(255) NULL,
	transaction_amount varchar(255) NULL,
	transaction_currency varchar(255) NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT transaction_amounts_pkey PRIMARY KEY (id)
);

CREATE TABLE proaccount.account_from (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	account_name varchar(255) NOT NULL,
	account_type varchar(255) NOT NULL,
	account_id varchar(255) NOT NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT account_from_pkey PRIMARY KEY (id)
);

CREATE TABLE proaccount.account_to (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	account_name varchar(255) NOT NULL,
	account_type varchar(255) NOT NULL,
	account_id varchar(255) NOT NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT account_to_pkey PRIMARY KEY (id)
);

CREATE TABLE proaccount.local_data (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	short_name varchar(255) NULL,
	legal_corporate_name varchar(255) NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT local_data_pkey PRIMARY KEY (id)
);

CREATE TABLE proaccount.card (
	id uuid NOT NULL,
	primary_account_number varchar(255) NOT NULL,
	protected_pan_indicator bool NULL,
	card_sequence_number varchar(255) NULL,
	payment_account_reference varchar(255) NULL,
	pan_account_range varchar(255) NULL,
	card_portfolio_identifier varchar(255) NULL,
	card_country_code varchar(255) NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT card_pkey PRIMARY KEY (id)
);

CREATE TABLE proaccount.transaction_identification (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	local_date varchar(255) NULL,
	system_trace_audit_number varchar(255) NULL,
	retrieval_reference_number varchar(255) NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT transaction_identification_pkey PRIMARY KEY (id)
);

CREATE TABLE proaccount.transaction (
	id uuid NOT NULL,
	transaction_type varchar(255) NULL,
	transaction_sub_type varchar(255) NULL,
	transaction_attribute varchar(255) NULL,
	other_transaction_attribute varchar(255) NULL,
	pre_authorisation_time_limit varchar(255) NULL,
	associated_data_indicator bool NULL,
	associated_data_reference varchar(255) NULL,
	associated_data_destination varchar(255) NULL,
	transaction_identification_id uuid NULL,
	transaction_amounts_id uuid NULL,
	transaction_description varchar(255) NULL,
	account_from_id uuid NULL,
	account_to_id uuid NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT transaction_pkey PRIMARY KEY (id),
	CONSTRAINT transaction_account_from_id_fkey FOREIGN KEY (account_from_id) REFERENCES proaccount.account_from(id),
	CONSTRAINT transaction_account_to_id_fkey FOREIGN KEY (account_to_id) REFERENCES proaccount.account_to(id),
	CONSTRAINT transaction_transaction_amounts_id_fkey FOREIGN KEY (transaction_amounts_id) REFERENCES proaccount.transaction_amounts(id),
	CONSTRAINT transaction_transaction_identification_id_fkey FOREIGN KEY (transaction_identification_id) REFERENCES proaccount.transaction_identification(id)
);

CREATE TABLE proaccount.additional_data (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	"type" varchar(255) NULL,
	value varchar(255) NULL,
	local_data_id uuid NULL,
	card_id uuid NULL,
	transaction_id uuid NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT additional_data_pkey PRIMARY KEY (id),
	CONSTRAINT additional_data_local_data_id_fkey FOREIGN KEY (local_data_id) REFERENCES proaccount.local_data(id),
	CONSTRAINT fk_card_id FOREIGN KEY (card_id) REFERENCES proaccount.card(id),
	CONSTRAINT fk_transaction_id FOREIGN KEY (transaction_id) REFERENCES proaccount.transaction(id)
);

CREATE TABLE proaccount.acquirer (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	identification varchar(255) NOT NULL,
	assigner varchar(255) NULL,
	country varchar(255) NULL,
	short_name varchar(255) NULL,
	legal_corporate_name varchar(255) NULL,
	additional_identification_id uuid NULL,
	local_data_id uuid NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT acquirer_pkey PRIMARY KEY (id),
	CONSTRAINT acquirer_additional_identification_id_fkey FOREIGN KEY (additional_identification_id) REFERENCES proaccount.additional_data(id),
	CONSTRAINT acquirer_local_data_id_fkey FOREIGN KEY (local_data_id) REFERENCES proaccount.local_data(id)
);

CREATE TABLE proaccount.initiating_party (
	id uuid NOT NULL,
	identification varchar(255) NULL,
	"type" varchar(255) NULL,
	other_type varchar(255) NULL,
	assigner varchar(255) NULL,
	country varchar(255) NULL,
	short_name varchar(255) NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT initiating_party_pkey PRIMARY KEY (id)
);

CREATE TABLE proaccount.issuer (
	id uuid NOT NULL,
	identification varchar(255) NULL,
	assigner varchar(255) NULL,
	country varchar(255) NULL,
	short_name varchar(255) NULL,
	legal_corporate_name varchar(255) NULL,
	additional_identification_id uuid NULL,
	local_data_id uuid NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT issuer_pkey PRIMARY KEY (id),
	CONSTRAINT issuer_additional_identification_id_fkey FOREIGN KEY (additional_identification_id) REFERENCES proaccount.additional_data(id),
	CONSTRAINT issuer_local_data_id_fkey FOREIGN KEY (local_data_id) REFERENCES proaccount.local_data(id)
);

CREATE TABLE proaccount.transaction_alternate_message_reason (
	transaction_id uuid NULL,
	alternate_message_reason varchar(255) NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT transaction_alternate_message_reason_transaction_id_fkey FOREIGN KEY (transaction_id) REFERENCES proaccount."transaction"(id)
);

CREATE TABLE proaccount.transaction_message_reason (
	transaction_id uuid NULL,
	message_reason varchar(255) NULL,
	timestmp timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT transaction_message_reason_transaction_id_fkey FOREIGN KEY (transaction_id) REFERENCES proaccount.transaction(id)
);
CREATE MATERIALIZED VIEW proaccount.AvailableBalance AS
SELECT a.Account_Number Number, a.Ledger_Balance - COALESCE(pt.PendingAmount, 0) AS AvailableBalance
FROM proaccount.Account a
LEFT JOIN (
    SELECT Account_Number, SUM(Transaction_Value) AS PendingAmount
    FROM proaccount.Pending_Transactions
    GROUP BY Account_Number
) pt ON a.Account_Number = pt.Account_Number;
