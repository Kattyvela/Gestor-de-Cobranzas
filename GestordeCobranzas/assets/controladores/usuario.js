applicacion.controller('UsuarioController',['$scope','toastr','UsuarioFactory',
    function($scope, toastr,UsuarioFactory){

    toastr.success('Nuevo Usuario', 'Has accedido a la vista nuevoUsuario');
    console.log('vistausuario');

    //VARIABLES SCOPE
    $scope.nuevoUsuario = {
        CI:'',
        RUC:'',
        RazonSocial:'',
        Telefono_1:'',
        Telefono_2:'',
        direccion:'',
    };

    //**********************OPERACIONES CRUD************************//
    // AGREGAR USUARIO
    $scope.agregarNuevoUsuario = function(){

        UsuarioFactory.save({
            CI: $scope.nuevoUsuario.CI,
            RUC: $scope.nuevoUsuario.RUC,
            RazonSocial: $scope.nuevoUsuario.RazonSocial,
            Telefono_1: $scope.nuevoUsuario.Telefono_1,
            Telefono_2: $scope.nuevoUsuario.Telefono_2,
            direccion: $scope.nuevoUsuario.direccion,
        })
        .$promise.then(
        function saveUsuario(respuesta){
            toastr.success('Exito', 'Se registro el cliente con CI: '+respuesta.CI);
            console.log(respuesta);
             $scope.nuevoUsuario = {
                CI:'',
                RUC:'',
                RazonSocial:'',
                Telefono_1:'',
                Telefono_2:'',
                direccion:'',
            };
        },
        function errorSaveUsuario(error){
            console.log(error);
            toastr.error('Error', 'Error inesperado del servidor');
        });

    };
}]);
