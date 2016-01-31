SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuario_unidad_negocio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Usuario_unidad_negocio` (
  `id_Usuario_unidad_negocio` INT NOT NULL AUTO_INCREMENT ,
  `id_usuario` INT NOT NULL ,
  `id_unidad_negocio` INT NULL ,
  `activo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id_Usuario_unidad_negocio`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `id_Cliente` INT NOT NULL AUTO_INCREMENT ,
  `cedula_ruc` VARCHAR(13) NOT NULL ,
  `cod_cliente` VARCHAR(8) NOT NULL ,
  `telefono1` VARCHAR(10) NOT NULL ,
  `telefono2` VARCHAR(10) NOT NULL ,
  `direccion` VARCHAR(45) NOT NULL ,
  `registro_activo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id_Cliente`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Mora`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Mora` (
  `id_Mora` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(150) NOT NULL ,
  `nro_factura` INT NOT NULL ,
  `fecha_facturacion` DATE NOT NULL ,
  `plazo` VARCHAR(45) NOT NULL ,
  `dias_en_mora` INT NOT NULL ,
  `saldo_total_de_factura` DOUBLE NOT NULL ,
  `Usuario_unidad_negocio_id_Usuario_unidad_negocio` INT NOT NULL ,
  `Cliente_id_Cliente` INT NOT NULL ,
  PRIMARY KEY (`id_Mora`, `Usuario_unidad_negocio_id_Usuario_unidad_negocio`, `Cliente_id_Cliente`) ,
  INDEX `fk_Mora_Usuario_unidad_negocio1` (`Usuario_unidad_negocio_id_Usuario_unidad_negocio` ASC) ,
  INDEX `fk_Mora_Cliente1` (`Cliente_id_Cliente` ASC) ,
  CONSTRAINT `fk_Mora_Usuario_unidad_negocio1`
    FOREIGN KEY (`Usuario_unidad_negocio_id_Usuario_unidad_negocio` )
    REFERENCES `mydb`.`Usuario_unidad_negocio` (`id_Usuario_unidad_negocio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mora_Cliente1`
    FOREIGN KEY (`Cliente_id_Cliente` )
    REFERENCES `mydb`.`Cliente` (`id_Cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tipo_Gestion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Tipo_Gestion` (
  `id_Tipo_Gestion` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `registro_activo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id_Tipo_Gestion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Resultado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Resultado` (
  `id_Resultado` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `registro_activo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id_Resultado`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Gestion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Gestion` (
  `id_Gestion` INT NOT NULL AUTO_INCREMENT ,
  `fecha_gestion` DATE NOT NULL ,
  `observaciones` VARCHAR(80) NOT NULL ,
  `Tipo_Gestion_id_Tipo_Gestion` INT NOT NULL ,
  `Mora_id_Mora` INT NOT NULL ,
  `Resultado_id_Resultado` INT NOT NULL ,
  PRIMARY KEY (`id_Gestion`, `Mora_id_Mora`, `Resultado_id_Resultado`) ,
  INDEX `fk_Gestion_Tipo_Gestion1` (`Tipo_Gestion_id_Tipo_Gestion` ASC) ,
  INDEX `fk_Gestion_Mora1` (`Mora_id_Mora` ASC) ,
  INDEX `fk_Gestion_Resultado1` (`Resultado_id_Resultado` ASC) ,
  CONSTRAINT `fk_Gestion_Tipo_Gestion1`
    FOREIGN KEY (`Tipo_Gestion_id_Tipo_Gestion` )
    REFERENCES `mydb`.`Tipo_Gestion` (`id_Tipo_Gestion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gestion_Mora1`
    FOREIGN KEY (`Mora_id_Mora` )
    REFERENCES `mydb`.`Mora` (`id_Mora` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gestion_Resultado1`
    FOREIGN KEY (`Resultado_id_Resultado` )
    REFERENCES `mydb`.`Resultado` (`id_Resultado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Respuesta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Respuesta` (
  `id_Respuesta` INT NOT NULL AUTO_INCREMENT ,
  `respuesta_cliente` VARCHAR(45) NULL ,
  `fecha_compromiso_pago` DATE NULL ,
  `fecha_respuesta` DATE NULL ,
  `Gestion_id_Gestion` INT NOT NULL ,
  PRIMARY KEY (`id_Respuesta`, `Gestion_id_Gestion`) ,
  INDEX `fk_Respuesta_Gestion_idx` (`Gestion_id_Gestion` ASC) ,
  CONSTRAINT `fk_Respuesta_Gestion`
    FOREIGN KEY (`Gestion_id_Gestion` )
    REFERENCES `mydb`.`Gestion` (`id_Gestion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Forma_Pago`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Forma_Pago` (
  `id_Forma_Pago` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `registro_activo` TINYINT(1) NOT NULL ,
  `Forma_Pagocol1` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_Forma_Pago`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Abono_Deuda`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Abono_Deuda` (
  `id_Abono_Deuda` INT NOT NULL AUTO_INCREMENT ,
  `fecha_abono` DATE NOT NULL ,
  `abono` DOUBLE NOT NULL ,
  `Mora_id_Mora` INT NOT NULL ,
  `Mora_Usuario_unidad_negocio_id_Usuario_unidad_negocio` INT NOT NULL ,
  `Mora_Cliente_id_Cliente` INT NOT NULL ,
  `Forma_Pago_id_Forma_Pago` INT NOT NULL ,
  PRIMARY KEY (`id_Abono_Deuda`, `Mora_id_Mora`, `Mora_Usuario_unidad_negocio_id_Usuario_unidad_negocio`, `Mora_Cliente_id_Cliente`, `Forma_Pago_id_Forma_Pago`) ,
  INDEX `fk_Abono_Deuda_Mora1` (`Mora_id_Mora` ASC, `Mora_Usuario_unidad_negocio_id_Usuario_unidad_negocio` ASC, `Mora_Cliente_id_Cliente` ASC) ,
  INDEX `fk_Abono_Deuda_Forma_Pago1` (`Forma_Pago_id_Forma_Pago` ASC) ,
  CONSTRAINT `fk_Abono_Deuda_Mora1`
    FOREIGN KEY (`Mora_id_Mora` , `Mora_Usuario_unidad_negocio_id_Usuario_unidad_negocio` , `Mora_Cliente_id_Cliente` )
    REFERENCES `mydb`.`Mora` (`id_Mora` , `Usuario_unidad_negocio_id_Usuario_unidad_negocio` , `Cliente_id_Cliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Abono_Deuda_Forma_Pago1`
    FOREIGN KEY (`Forma_Pago_id_Forma_Pago` )
    REFERENCES `mydb`.`Forma_Pago` (`id_Forma_Pago` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
