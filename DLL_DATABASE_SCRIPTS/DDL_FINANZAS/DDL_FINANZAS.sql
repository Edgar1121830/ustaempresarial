/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created by:     THE ALIRIOS		                            */
/*==============================================================*/

create schema finanzas;
/*==============================================================*/
/* Table: log_cuentas                                         */
/*==============================================================*/
CREATE TABLE finanzas.log_cuentas
(
    CODIGO_cuenta_nueva      INTEGER PRIMARY KEY    NOT NULL,
    NOMBRE_cuenta_nueva      CHARACTER VARYING(100) NOT NULL,
    DESCRIPCION_cuenta_nueva CHARACTER VARYING(300) NOT NULL,
    TIPO_cuenta_nueva        INTEGER                NOT NULL,
    VIGENCIA_cuenta_nueva    DATE                   NOT NULL
);

COMMENT ON TABLE finanzas.log_cuentas
    IS 'Tabla donde se almacenan cada cuenta que entra como nueva ';

COMMENT ON COLUMN finanzas.log_cuentas.CODIGO_cuenta_nueva IS 'Código de la cuenta nueva – PUC';
COMMENT ON COLUMN finanzas.log_cuentas.NOMBRE_cuenta_nueva IS 'NOMBRE de la cuenta nueva';
COMMENT ON COLUMN finanzas.log_cuentas.DESCRIPCION_cuenta_nueva IS 'Descripción de la cuenta nueva';
COMMENT ON COLUMN finanzas.log_cuentas.TIPO_cuenta_nueva IS 'Clase(1), grupo(2),cuenta(3), subcuenta(4)';
COMMENT ON COLUMN finanzas.log_cuentas.VIGENCIA_cuenta_nueva IS 'Fecha de inicio de VIGENCIA de la cuenta nueva';

/*==============================================================*/
/* Table: plan_contable                                         */
/*==============================================================*/
CREATE TABLE finanzas.plan_contable
(
    CODIGO       INTEGER PRIMARY KEY    NOT NULL,
    NOMBRE       CHARACTER VARYING(100) NOT NULL,
    DESCRIPCION  CHARACTER VARYING(300) NOT NULL,
    TIPO         INTEGER                NOT NULL,
    VIGENCIA     DATE                   NOT NULL,
    CODIGO_PADRE INTEGER
);

COMMENT ON TABLE finanzas.plan_contable
    IS 'Tabla donde se almacenan todo el plan unico de cuentas ';

COMMENT ON COLUMN finanzas.plan_contable.CODIGO IS 'Código de la cuenta – PUC';
COMMENT ON COLUMN finanzas.plan_contable.NOMBRE IS 'NOMBRE de la cuenta';
COMMENT ON COLUMN finanzas.plan_contable.DESCRIPCION IS 'Descripción de la cuenta';
COMMENT ON COLUMN finanzas.plan_contable.TIPO IS 'Clase(1), grupo(2),cuenta(3), subcuenta(4)';
COMMENT ON COLUMN finanzas.plan_contable.VIGENCIA IS 'Fecha de inicio de VIGENCIA';
COMMENT ON COLUMN finanzas.plan_contable.CODIGO_PADRE IS 'Identificador de padre';

ALTER TABLE finanzas.plan_contable
    ADD CONSTRAINT "Fk_PLANCONTABLE_PLANCONTABLE" FOREIGN KEY (CODIGO_PADRE)
        REFERENCES finanzas.plan_contable (CODIGO);


/*==============================================================*/
/* Table: periodo                                               */
/*==============================================================*/
CREATE TABLE finanzas.periodo
(
    CODIGO       SERIAL PRIMARY KEY NOT NULL,
    FECHA_INICIO DATE               NOT NULL,
    FECHA_FIN    DATE               NOT NULL,
    ESTADO       BOOLEAN            NOT NULL

);

COMMENT ON TABLE finanzas.periodo
    IS 'Tabla donde se almacenan el periodo contable ';

COMMENT ON COLUMN finanzas.periodo.CODIGO IS 'codigo del periodo';
COMMENT ON COLUMN finanzas.periodo.FECHA_INICIO IS 'fecha inicio';
COMMENT ON COLUMN finanzas.periodo.FECHA_FIN IS 'fecha final';
COMMENT ON COLUMN finanzas.periodo.ESTADO IS 'Activo (1), inactivo (0)';

/*==============================================================*/
/* Table: libro_mayor                                           */
/*==============================================================*/
CREATE TABLE finanzas.libro_mayor
(
    PLAN_CONTABLE_COD SERIAL  NOT NULL,
    PERIODO_COD       INTEGER NOT NULL,
    DEBE              DECIMAL NOT NULL,
    HABER             DECIMAL NOT NULL,
    FECHA             DATE    NOT NULL,
    ESTADO            BOOLEAN NOT NULL,
    PRIMARY KEY (PLAN_CONTABLE_COD, PERIODO_COD)
);

COMMENT ON TABLE finanzas.libro_mayor
    IS 'Tabla donde se almacenan EL LIBRO MAYOR';

COMMENT ON COLUMN finanzas.libro_mayor.PLAN_CONTABLE_COD is 'Código de la tabla plan_contable';
COMMENT ON COLUMN finanzas.libro_mayor.PERIODO_COD is 'Código del periodo contable';
COMMENT ON COLUMN finanzas.libro_mayor.DEBE is 'Valor total del debe (valores positivos) en la tabla libro_diario';
COMMENT ON COLUMN finanzas.libro_mayor.HABER is 'Valor total del haber (valores negativos) en la tabla libro_diario';
COMMENT ON COLUMN finanzas.libro_mayor.FECHA is 'Fecha de generación del libro mayor';
COMMENT ON COLUMN finanzas.libro_mayor.ESTADO is 'Activo (1), inactivo (0)';

ALTER TABLE finanzas.libro_mayor
    ADD CONSTRAINT "FK_PLANCONTABLE_LIBROMAYOR" FOREIGN KEY (PLAN_CONTABLE_COD)
        REFERENCES finanzas.PLAN_CONTABLE (CODIGO);

ALTER TABLE finanzas.libro_mayor
    ADD CONSTRAINT "FK_PERIODO_LIBROMAYOR" FOREIGN KEY (PERIODO_COD)
        REFERENCES finanzas.periodo (CODIGO);


/*==============================================================*/
/* Table: concepto                                              */
/*==============================================================*/
CREATE TABLE finanzas.concepto
(
    CODIGO               SERIAL                NOT NULL PRIMARY KEY,
    NOMBRE               CHARACTER VARYING(20) NOT NULL,
    DESCRPCION           CHARACTER VARYING(100),
    TIPO                 BOOLEAN               NOT NULL,
    ESTADO               BOOLEAN               NOT NULL,
    PLAN_CONTABLE_CODIGO INTEGER               NOT NULL
);


ALTER TABLE finanzas.concepto
    ADD CONSTRAINT "FK_PLANCONTABLE_CONCEPTO_PL" FOREIGN KEY (PLAN_CONTABLE_CODIGO)
        REFERENCES finanzas.PLAN_CONTABLE (CODIGO);

COMMENT ON TABLE finanzas.concepto
    IS 'Tabla donde se almacenan los datos de cada cargo o los CONCEPTOS ';

COMMENT ON COLUMN finanzas.concepto.CODIGO
    IS 'Llave primaria de la tabla CONCEPTO, CODIGO del cargo';

COMMENT ON COLUMN finanzas.concepto.DESCRPCION
    IS 'Funciones del cargo ';

COMMENT ON COLUMN finanzas.concepto.TIPO
    IS 'Define el TIPO del cargo y Los valores son: (1)Debe (0)Haber';

COMMENT ON COLUMN finanzas.concepto.ESTADO
    IS 'Este atributo define el ESTADO de actividad o inactividad del cargo donde: (1) Activo (0) Inactivo';

COMMENT ON COLUMN finanzas.concepto.PLAN_CONTABLE_CODIGO
    IS 'CODIGO de la tabla plan contable';

COMMENT ON COLUMN finanzas.concepto.NOMBRE
    IS 'NOMBRE del cargo';


/*==============================================================*/
/* Table: libro_diario                                          */
/*==============================================================*/
CREATE TABLE finanzas.libro_diario
(
    ASIENTO      SERIAL PRIMARY KEY NOT NULL,
    FECHA        DATE               NOT NULL,
    VALOR        DECIMAL            NOT NULL,
    PERIODO_COD  INTEGER            NOT NULL,
    CONCEPTO_COD INTEGER            NOT NULL,
    ESTADO       BOOLEAN            NOT NULL
);

COMMENT ON TABLE finanzas.libro_diario
    IS 'Tabla donde se almacenan EL LIBRO DIARIO ';

COMMENT ON COLUMN finanzas.libro_diario.ASIENTO IS 'Código secuencial del movimiento contable';
COMMENT ON COLUMN finanzas.libro_diario.FECHA IS 'Fecha del movimiento contable';
COMMENT ON COLUMN finanzas.libro_diario.VALOR IS 'Valor del asiento contable';
COMMENT ON COLUMN finanzas.libro_diario.PERIODO_COD IS 'Código del periodo contable';
COMMENT ON COLUMN finanzas.libro_diario.CONCEPTO_COD IS 'Código del concepto contable';
COMMENT ON COLUMN finanzas.libro_diario.ESTADO IS 'Activo (1), inactivo(0)';

ALTER TABLE finanzas.libro_diario
    ADD CONSTRAINT "Fk_LIBRODIARIO_PERIODO" FOREIGN KEY (PERIODO_COD)
        REFERENCES finanzas.periodo (CODIGO);

ALTER TABLE finanzas.libro_diario
    ADD CONSTRAINT "Fk_LIBRODIARIO_CONCEPTO" FOREIGN KEY (CONCEPTO_COD)
        REFERENCES finanzas.concepto (CODIGO);
