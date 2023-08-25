angular.module("mega").config(function ($routeProvider) {
	$routeProvider.when("/home", {
		templateUrl: "pages/home/home.html",

	});
    $routeProvider.when("/perfil", {
		templateUrl: "/pages/perfil/perfil.html",
		
	});
	$routeProvider.when("/bairro", {
		templateUrl: "pages/bairro/bairro.html",
		
	});
	
	$routeProvider.otherwise({redirectTo: "/"});
});