CREATE EXTENSION IF NOT EXISTS "pgcrypto";
    INSERT INTO cliente (id, total, limite)
      VALUES
        (1, 0, 1000 * 100),
        (2, 0, 800 * 100),
        (3, 0, 10000 * 100),
        (4, 0, 100000 * 100),
        (5, 0, 5000 * 100);