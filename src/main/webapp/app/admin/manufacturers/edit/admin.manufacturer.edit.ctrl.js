/**
 * Created by Ivan on 09.04.2017.
 */
(function () {
    'use strict';

    angular
        .module('main')
        .controller('ManufacturerEditCtrl', ManufacturerEditCtrl);

    function ManufacturerEditCtrl($scope, ManufacturersService, $stateParams) {

        var sc = $scope;
        sc.manufacturerId = $stateParams.manufacturerId;

        sc.updateManufacturer = function (manufacturer) {

            function success(response) {
            };

            function failed(response) {
            };

            ManufacturersService.update(manufacturer).then(success, failed);
        };

        sc.getOne = function (id) {

            function success(response) {
                sc.manufacturer = response.data;
            };

            function failed(response) {
                sc.manufacturer = response.data;
            };

            ManufacturersService.getOneById(id).then(success, failed);
        };

    }
})();

