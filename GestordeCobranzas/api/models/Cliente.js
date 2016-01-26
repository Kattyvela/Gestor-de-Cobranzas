/**
* Cliente.js
*
* @description :: TODO: You might write a short summary of how this model works and what it represents here.
* @docs        :: http://sailsjs.org/#!documentation/models
*/

module.exports = {

  attributes: {
    CI: {
      type:'string'
    },
    RUC: {
      type:'string'
    },
    RazonSocial: {
      type:'string'
    },
    Telefono_1: {
      type:'string'
    },
    Telefono_2: {
      type:'string'
    },
    direccion: {
      type:'string'
    },
    facturas: {
      collection:'Factura',
      via: 'id_cliente'
    }
    
      
    

  }
};

