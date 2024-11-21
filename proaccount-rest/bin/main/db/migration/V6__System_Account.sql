INSERT INTO proshared.tenant (tenant_name, tenant_status) 
VALUES ('Nimbuspay-RECIEVABLE', 'Active');
INSERT INTO proshared.tenant (tenant_name, tenant_status) 
VALUES ('Nimbuspay-PAYABLE', 'Active');

INSERT INTO proshared.product (
    tenant, 
    product_name, 
    product_status
) 
VALUES (
    'Nimbuspay-RECIEVABLE', 
    'NBP RECIEVABLE', 
    'ACTIVE'
);

INSERT INTO proshared.product (
    tenant, 
    product_name, 
    product_status
) 
VALUES (
    'Nimbuspay-PAYABLE', 
    'NBP PAYABLE', 
    'ACTIVE'
);

INSERT INTO procustomer.core_identity (
    customer_number, 
    tenant_name, 
    first_name, 
    family_surname, 
    date_of_birth, 
    place_of_birth
) 
VALUES (
    123451235432, 
    'Nimbuspay-RECIEVABLE', 
    'Nimbuspay-System Account',  
    'Doe', 
    '1980-01-01', 
    'United Kingtom'
);

INSERT INTO procustomer.core_identity (
    customer_number, 
    tenant_name, 
    first_name, 
    family_surname, 
    date_of_birth, 
    place_of_birth
) 
VALUES (
    543214456755, 
    'Nimbuspay-PAYABLE', 
    'Nimbuspay-System Account', 
    'Doe', 
    '1980-01-01', 
    'United Kingtom'
);

INSERT INTO proaccount.account (
    account_id, 
    timestmp, 
    account_number, 
    account_owner, 
    account_type, 
    iso4217_currency, 
    product, 
    ledger_balance, 
    deleted
)
VALUES (
    uuid_generate_v4(), 
    CURRENT_TIMESTAMP, 
   111122223333, 
    123451235432, 
    'RECEIVABLE', 
    'GBP', 
    'NBP RECIEVABLE', 
    0.0, 
    false
);

INSERT INTO proaccount.account (
    account_id, 
    timestmp, 
    account_number, 
    account_owner, 
    account_type, 
    iso4217_currency, 
    product, 
    ledger_balance, 
    deleted
)
VALUES (
    uuid_generate_v4(), 
    CURRENT_TIMESTAMP, 
   444433332222, 
    543214456755, 
    'PAYABLE', 
    'GBP', 
    'NBP PAYABLE', 
    0.0, 
    false
);
