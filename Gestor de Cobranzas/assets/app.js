var app = angular.module('Gestor', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {
  //
  // For any unmatched url, redirect to /state1
  
  $urlRouterProvider.otherwise("/");
  //
  // Now set up the states
  $stateProvider
    .state('usuario', {
      url: "/usuario",
      templateUrl: "/rutas/usuario.html"
    })
    .state('agente', {
      url: "/agente",
      templateUrl: "/rutas/agente.html"
    });
    
});