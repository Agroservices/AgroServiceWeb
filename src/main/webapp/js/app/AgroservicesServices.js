(function () {
    var app = angular.module('AgroservicesServices', []);

    app.service('AgroservicesRestAPI', function ($http) {
        
        this.getVentas = function () {
            return $http.get('/rest/ventas/');
        };
        
        this.getVentasByCampesino = function (id) {
            return $http.get('/rest/ventas/'+id);
        };
        
        this.getProductosConsultaCompra = function(){
            return $http.get('/rest/productos/');
        };
        
        this.getProductosEnVentaConsulta = function(id){
            //alert(id);
            return $http.get('/rest/productosEnVenta/'+id);
        };
        

        this.validarInformacionTarjeta = function (numeroTar,codigoTar,tipoTar,nombreCli,cuentaDes,descripcion,montoTrans){
            
            var tarjeta = {"numeroTarjeta":numeroTar,"codigoSeguridad":codigoTar,"tipo":tipoTar,"nombreCliente":nombreCli,"cuentaDestino":cuentaDes,"descripcion":descripcion,"montoTransaccion":montoTrans};
            alert(angular.toJson(tarjeta));
            return $http({
                method: 'POST',
                //url: '/rest/compras/tarjetaValidacion/',
                url: 'http://paymentsgateway.herokuapp.com/rest/payments',
                data: tarjeta
            });

        };
        
        this.getTransaccion = function (codigoTransaccion){
            return $http.get('/rest/compras/transaccion/'+codigoTransaccion);
        };
        
        this.agregarFactura = function (transaccion,impuestoFactura,idProductoEnVenta,idMinorista,cantidad){
            
            var factura = {"transaccionesBancarias":transaccion,"impuesto":impuestoFactura}
            return $http({
                method: 'POST',
                url: 'rest/compras/'+idMinorista+'/'+idProductoEnVenta+'/'+cantidad,
                data: factura
            });
            
        };
        
        this.getTarjeta = function (){
           return $http.get('/rest/compras/tarjetaValidacion/');
        };

        this.postProductosEnVenta = function(productoEnVenta,idCampesino){
            return $http.post('/rest/campesinos/'+idCampesino+'/productosEnVenta'
            ,productoEnVenta);
        };
        
        this.getProductosEnVentaPorCampesino = function(idCampesino){
            return $http.get('/rest/campesinos/'+idCampesino+'/productosEnVenta');
        };
        
        this.postProducto = function(producto){
          return $http.post('/rest/productos/',producto);  
        };
        
        this.getRutas = function () {
            return $http.get('/rest/despachos/');
        };
        
        this.getRutasByTransportsta = function (idTransportista) {
            return $http.get('/rest/rutas/transportista/'+idTransportista);
            //return $http.get('/rest/despachos/transportista/'+idTransportista);
        };
        
        this.asignarRuta = function (idRuta){
            return $http.get('/rest/rutas/asignar/'+idRuta);
        };
        
        this.getDspachosByRuta = function (idRuta){
            return $http.get('/rest/despachos/rutas/'+idRuta);
        };
        
        this.getNombreMinorista = function (idMinorista){
            return $http.get('/rest/minoristas/nombre/'+idMinorista);
        };
        
         this.postModificarProductoEnVenta = function(productoModificado){
            return $http.post('/rest/productosEnVenta/modificarProductoEnVenta',productoModificado);
        };
        
        
    }
    );

})();





