CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE transacao (
    id INTEGER NOT NULL UNIQUE PRIMARY KEY,
    valor INTEGER NOT NULL,
    tipo VARCHAR(1),
    descricao VARCHAR(10),
    realizada_em TIMESTAMP,
    id_cliente INTEGER,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE CASCADE
);