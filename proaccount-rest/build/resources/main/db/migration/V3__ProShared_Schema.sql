CREATE TABLE proshared.tenant (
    tenant_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    timestmp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tenant_name VARCHAR(40) NOT NULL UNIQUE,
    tenant_status VARCHAR(26) NOT NULL
);

CREATE TABLE proshared.product (
    product_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    timestmp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tenant VARCHAR(40),
    product_name VARCHAR(40) NOT NULL UNIQUE,
    product_status VARCHAR(26) NOT NULL,
    FOREIGN KEY (tenant) REFERENCES proshared.tenant(tenant_name)
);