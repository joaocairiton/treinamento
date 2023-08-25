angular.module("listaCliente",[])
        .controller("listaClienteCtrl", function ($scope, clientesAPI, operadorasAPI) {
            
            $scope.app = "Lista Telefonica"; 
            $scope.Cliente  =[];
            $scope.Operadoras = [];

        var buscarCliente = function (){
            clientesAPI.getClientes().then(function (res){
            
            $scope.Cliente = res.data;
            });
        };

        var getOperadora = function (){
            operadorasAPI.getOperadoras().then(function (res){
            
            $scope.Operadoras = res.data;
            });
        }
    

        $scope.removeCliente = function (Cliente) {
           $scope.Cliente = Cliente.filter(function (clientes) { 
                if (!clientes.selecionado) return clientes;          
        });

        };

        $scope.isClienteSelecionado = function (Cliente) {
            return Cliente.some(function (clientes){
                return clientes.selecionado;

            });
            
        };
   
        $scope.addCliente = function (clientes) {

            
            clientes.data = new Date();
          clientesAPI.saveClientes(clientes).then(function (res) {
            $scope.clientes = res.data;
            buscarCliente();
            delete $scope.clientes;
            $scope.clienteFom.$setPristine();
        

          });
            
        };

        $scope.ordernarPor = function (campo ){
            $scope.order = campo;
            $scope.reverse =!$scope.reverse;


    };
        buscarCliente();
        getOperadora();      
        
});