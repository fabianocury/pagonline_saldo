CREATE TABLE saldo (
    id_cliente bigint(20) NOT NULL,
    saldo_efetivo decimal(19,2) NOT NULL,
    saldo_congelado decimal(19,2) NOT NULL,
    PRIMARY KEY (id_cliente)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
