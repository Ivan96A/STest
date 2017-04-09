
(function () {
    'use strict';

    angular
        .module('main')
        .controller('ManufacturerAddCtrl', ManufacturerAddCtrl);

    function ManufacturerAddCtrl($scope, ManufacturersService) {

        var sc = $scope;


        sc.saveManufacturer = function (manufacturer) {
            function success(response) {
            };

            function failed(response) {
            };

            ManufacturersService.save(manufacturer).then(success, failed);
        };
    }
})();
