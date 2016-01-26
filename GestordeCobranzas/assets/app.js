var applicacion = angular.module('Gestor', ['ui.router','ngResource','toastr']);

applicacion.config(function($stateProvider, $urlRouterProvider) {
  //
  // For any unmatched url, redirect to /state1
  
  $urlRouterProvider.otherwise("/");
  //
  // Now set up the states
  $stateProvider
    .state('usuario', {
      url: "/usuario",
      templateUrl: "/rutas/usuario.html",
      controller: 'UsuarioController'
    })
    .state('agente', {
      url: "/agente",
      templateUrl: "/rutas/agente.html"
    });
    
});