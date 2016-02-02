/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     1/2/2016 23:21:13                            */
/*==============================================================*/



/*==============================================================*/
/* Table: ABONO_DEUDA                                           */
/*==============================================================*/
create table ABONO_DEUDA
(
   ID_ABONODEUDA        INT(11) NOT NULL AUTO_INCREMENT,
   ID_FORMAPAGO         int,
   ID_MORA              int,
   FECHAABONO           date,
   ABONO                decimal(10,3),
   primary key (ID_ABONODEUDA)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   ID_CLIENTE           int not null,
   CEDULA_RUC           char(10),
   RUC_CLIENTE          char(13),
   TELEFONO             char(12),
   TELF_REF1            char(12),
   TELF_REF2            char(12),
   DIRECCION            char(250),
   REGISTROACTIVO       char(50),
   primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Table: FORMA_DE_PAGO                                         */
/*==============================================================*/
create table FORMA_DE_PAGO
(
   ID_FORMAPAGO         INT(11) NOT NULL AUTO_INCREMENT,
   NOMBRE               char(100),
   REGISTROACTIVO       char(50),
   primary key (ID_FORMAPAGO)
);

/*==============================================================*/
/* Table: GESTION                                               */
/*==============================================================*/
create table GESTION
(
   ID_GESTION           INT(11) NOT NULL AUTO_INCREMENT,
   ID_RESPUESTA         int,
   ID_MORA              int,
   ID_TIPOGESTION       int,
   ID_RESULTADO         int,
   FECHAGESTION         date,
   OBSERVACIONES        char(255),
   primary key (ID_GESTION)
);

/*==============================================================*/
/* Table: MORA                                                  */
/*==============================================================*/
create table MORA
(
   ID_MORA              int not null,
   ID_USUARIOUNIDADNEGOCIO int,
   ID_CLIENTE           int,
   DESCRIPCION          char(200),
   NUMFACTURA           char(20),
   FECHAFACTURACION     date,
   PLAZO                date,
   DIASENMORA           int,
   SALDOTOTALFACTURAMORA decimal(12,3),
   primary key (ID_MORA)
);

/*==============================================================*/
/* Table: RESPUESTA                                             */
/*==============================================================*/
create table RESPUESTA
(
   ID_RESPUESTA         INT(11) NOT NULL AUTO_INCREMENT,
   ID_GESTION           int,
   RESPUESTACLIENTE     char(200),
   FECHACOMPROMISOPAGO  date,
   FECHARESPUESTA       date,
   primary key (ID_RESPUESTA)
);

/*==============================================================*/
/* Table: RESULTADO                                             */
/*==============================================================*/
create table RESULTADO
(
   ID_RESULTADO         INT(11) NOT NULL AUTO_INCREMENT,
   ID_TIPOGESTION       int,
   NOMBRE               char(100),
   REGISTROACTIVO       char(50),
   primary key (ID_RESULTADO)
);

/*==============================================================*/
/* Table: TIPO_GESTION                                          */
/*==============================================================*/
create table TIPO_GESTION
(
   ID_TIPOGESTION       INT(11) NOT NULL AUTO_INCREMENT,
   NOMBRE               char(100),
   REGISTROACTIVO       char(50),
   primary key (ID_TIPOGESTION)
);

/*==============================================================*/
/* Table: USUARIO_UNIDAD_NEGOCIO                                */
/*==============================================================*/
create table USUARIO_UNIDAD_NEGOCIO
(
   ID_USUARIOUNIDADNEGOCIO int not null,
   ID_USUARIO           int,
   ID_UNIDADNEGOCIO     int,
   NOMBRE_USUARIO       varchar(40),
   ACTIVO               varchar(30),
   primary key (ID_USUARIOUNIDADNEGOCIO)
);

alter table ABONO_DEUDA add constraint FK_RELATIONSHIP_4 foreign key (ID_MORA)
      references MORA (ID_MORA) on delete restrict on update restrict;

alter table ABONO_DEUDA add constraint FK_RELATIONSHIP_5 foreign key (ID_FORMAPAGO)
      references FORMA_DE_PAGO (ID_FORMAPAGO) on delete restrict on update restrict;

alter table GESTION add constraint FK_RELATIONSHIP_2 foreign key (ID_MORA)
      references MORA (ID_MORA) on delete restrict on update restrict;

alter table GESTION add constraint FK_RELATIONSHIP_3 foreign key (ID_RESULTADO)
      references RESULTADO (ID_RESULTADO) on delete restrict on update restrict;

alter table GESTION add constraint FK_RELATIONSHIP_6 foreign key (ID_RESPUESTA)
      references RESPUESTA (ID_RESPUESTA) on delete restrict on update restrict;

alter table GESTION add constraint FK_RELATIONSHIP_9 foreign key (ID_TIPOGESTION)
      references TIPO_GESTION (ID_TIPOGESTION) on delete restrict on update restrict;

alter table MORA add constraint FK_RELATIONSHIP_1 foreign key (ID_CLIENTE)
      references CLIENTE (ID_CLIENTE) on delete restrict on update restrict;

alter table MORA add constraint FK_RELATIONSHIP_8 foreign key (ID_USUARIOUNIDADNEGOCIO)
      references USUARIO_UNIDAD_NEGOCIO (ID_USUARIOUNIDADNEGOCIO) on delete restrict on update restrict;

alter table RESPUESTA add constraint FK_RELATIONSHIP_7 foreign key (ID_GESTION)
      references GESTION (ID_GESTION) on delete restrict on update restrict;

alter table RESULTADO add constraint FK_RELATIONSHIP_10 foreign key (ID_TIPOGESTION)
      references TIPO_GESTION (ID_TIPOGESTION) on delete restrict on update restrict;
