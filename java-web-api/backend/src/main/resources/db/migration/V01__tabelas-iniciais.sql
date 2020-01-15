
CREATE TABLE cliente (
    id bigint PRIMARY KEY noT NULL AUTO_INCREMENT,
    nome VARCHAR (100),
    endereco varchar(80),
    bairro varchar(80),
    complemento varchar(100),
    telefone varchar(15),
    numero_imovel int
);

CREATE TABLE ingrediente (
    id bigint  PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR (100),
    tipo VARCHAR (80),
    preco decimal(4,2)
    );

CREATE TABLE item_cardapio (
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR (100),
    tipo Varchar(80),
    preco decimal(4,2)
    );
 
 CREATE TABLE item_cardapio_ingrediente (
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  	item_cardapio_id bigint,
  	ingrediente_id bigint
);

ALTER TABLE `item_cardapio_ingrediente` ADD CONSTRAINT `fk_item_cardapio` 
 FOREIGN KEY ( `item_cardapio_id` ) REFERENCES `item_cardapio` ( `id` ) ;
 
ALTER TABLE `item_cardapio_ingrediente` ADD CONSTRAINT `fk_ingrediente` 
 FOREIGN KEY ( `ingrediente_id` ) REFERENCES `ingrediente` ( `id` ) ;
  

 
CREATE TABLE pedido (
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    item_cardapio_id bigint,
  	cliente_id bigint
    );

ALTER TABLE `pedido` ADD CONSTRAINT `fk_item_cardapio2` 
 FOREIGN KEY ( `item_cardapio_id` ) REFERENCES `item_cardapio` ( `id` ) ;

ALTER TABLE `pedido` ADD CONSTRAINT `fk_cliente` 
 FOREIGN KEY ( `cliente_id` ) REFERENCES `cliente` ( `id` ) ;
    

CREATE TABLE pedido_add_ingrediente (
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    pedido_id bigint,
  	ingrediente_id bigint
    );
    
ALTER TABLE `pedido_add_ingrediente` ADD CONSTRAINT `fk_pedido2` 
 FOREIGN KEY ( `pedido_id` ) REFERENCES `pedido` ( `id` ) ;

ALTER TABLE `pedido_add_ingrediente` ADD CONSTRAINT `fk_ingrediente2` 
 FOREIGN KEY ( `ingrediente_id` ) REFERENCES `ingrediente` ( `id` ) ;

    
 CREATE TABLE compra (
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  	status varchar(40),
  	data_hora date,
  	cliente_id bigint
);

ALTER TABLE `compra` ADD CONSTRAINT `fk_cliente2` 
 FOREIGN KEY ( `cliente_id` ) REFERENCES `cliente` ( `id` ) ;

 CREATE TABLE compra_pedido (
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
  	compra_id bigint,
  	pedido_id bigint
);

ALTER TABLE `compra_pedido` ADD CONSTRAINT `fk_compra` 
 FOREIGN KEY ( `compra_id` ) REFERENCES `compra` ( `id` ) ;
 
ALTER TABLE `compra_pedido` ADD CONSTRAINT `fk_pedido` 
 FOREIGN KEY ( `pedido_id` ) REFERENCES `pedido` ( `id` ) ;
 

