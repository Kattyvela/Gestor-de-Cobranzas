/**
* Factura.js
*
* @description :: TODO: You might write a short summary of how this model works and what it represents here.
* @docs        :: http://sailsjs.org/#!documentation/models
*/

module.exports = {

  attributes: {
    valor: {
      type:'float'
    },
    estado: {
      type:'string'
    },
    id_cliente: {
      model:'Cliente'
    }

  }
};

