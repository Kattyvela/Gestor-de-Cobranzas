applicacion.factory('UsuarioFactory',['$resource',function($resource){

    var factory = $resource(
        'https://libres-cchristico.c9users.io/Cliente/:idCliente',{
            idCliente:'@idCliente'
        },
        {
            actualizar: {
                method:'PUT',
                params:{
                    idCliente:'@idCliente'
                }
            }
         });

    return factory;

}]);

