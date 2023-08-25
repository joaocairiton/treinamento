angular.module("listaCliente").factory("clientesAPI", function ($http, config) {
    var _getClientes = function (){
        return $http.get(config.baseUrl + "/Cliente");
    };
    var _saveClientes = function (clientes){
        return $http.post(config.baseUrl + "/Cliente", clientes);
    };



    return{
        getClientes: _getClientes,
        saveClientes: _saveClientes
    };

});
