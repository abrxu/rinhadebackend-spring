CREATE TABLE cliente (
    id INTEGER NOT NULL UNIQUE PRIMARY KEY,
    total INTEGER NOT NULL,
    limite INTEGER NOT NULL
);

CREATE TABLE transacao (
    id INTEGER NOT NULL UNIQUE PRIMARY KEY,
    valor INTEGER NOT NULL,
    tipo VARCHAR(1),
    descricao VARCHAR(10),
    realizada_em TIMESTAMP,
    id_cliente INTEGER,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE CASCADE
);

INSERT INTO cliente (id, total, limite) VALUES (1, 0, 100000);
INSERT INTO cliente (id, total, limite) VALUES (2, 0, 80000);
INSERT INTO cliente (id, total, limite) VALUES (3, 0, 1000000);
INSERT INTO cliente (id, total, limite) VALUES (4, 0, 10000000);
INSERT INTO cliente (id, total, limite) VALUES (5, 0, 500000);