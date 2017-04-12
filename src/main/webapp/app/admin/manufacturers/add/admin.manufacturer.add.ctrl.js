
(function () {
    'use strict';

    angular
        .module('main')
        .controller('ManufacturerAddCtrl', ManufacturerAddCtrl);

    function ManufacturerAddCtrl($scope, ManufacturersService, $state) {

        var sc = $scope;


        sc.saveManufacturer = function (manufacturer) {
            function success(response) {
                $state.go("main.admin.manufacturers");
            };

            function failed(response) {
            };

            ManufacturersService.save(manufacturer).then(success, failed);


        };
    }
})();
