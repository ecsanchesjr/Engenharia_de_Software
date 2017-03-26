-- Gerado por Oracle SQL Developer Data Modeler 4.1.5.907
--   em:        2017-03-25 23:24:33 BRT
--   site:      Oracle Database 12c
--   tipo:      Oracle Database 12c




CREATE
  TABLE Pessoa
  (
    pessoa_tipo      INTEGER NOT NULL ,
    pessoa_nome      VARCHAR (100) NOT NULL ,
    pessoa_cpf       VARCHAR (20) NOT NULL ,
    pessoa_rg        VARCHAR (20) NOT NULL ,
    pessoa_regescola INTEGER NOT NULL ,
    pessoa_idade     INTEGER NOT NULL ,
    pessoa_permissao BOOLEAN ,
    pessoa_credito FLOAT(2) ,
    pessoa_emailresponsavel VARCHAR (100)
  ) ;
ALTER TABLE Pessoa ADD CONSTRAINT Pessoa_PK PRIMARY KEY ( pessoa_regescola ) ;


CREATE
  TABLE Tipo
  (
    tipo_codigo             INTEGER NOT NULL ,
    Pessoa_pessoa_regescola INTEGER NOT NULL
  ) ;


CREATE
  TABLE Validade
  (
    validade_limite         DATE NOT NULL ,
    Pessoa_pessoa_regescola INTEGER NOT NULL
  ) ;


ALTER TABLE Tipo ADD CONSTRAINT Tipo_Pessoa_FK FOREIGN KEY (
Pessoa_pessoa_regescola ) REFERENCES Pessoa ( pessoa_regescola ) ;

ALTER TABLE Validade ADD CONSTRAINT Validade_Pessoa_FK FOREIGN KEY (
Pessoa_pessoa_regescola ) REFERENCES Pessoa ( pessoa_regescola ) ON
DELETE CASCADE ;


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             0
-- ALTER TABLE                              3
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
