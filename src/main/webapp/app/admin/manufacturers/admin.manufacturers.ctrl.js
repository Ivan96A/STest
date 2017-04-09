/**
 * Created by Ivan on 04.04.2017.
 */
(function () {
    'use strict';

    angular
        .module('main')
        .controller('ManufacturersCtrl', ManufacturersCtrl);

    function ManufacturersCtrl($scope, $state, ManufacturersService, $location, ngDialog) {

        var sc = $scope;

        sc.getManufacturers = function () {

            function success(response) {
                sc.manufacturers = response.data;
            };

            function failed(response) {
                sc.manufacturers = response.data;
                console.log(response.status);
            };

            ManufacturersService.getAll().then(success, failed);
        };

        sc.getManufacturerById = function (name) {

            function success(response) {
                sc.manufacturer = response.data;
            };

            function failed(response) {
                sc.manufacturer = response.data;
                console.log(response.status);
            };

            ManufacturersService.getOneByName(name).then(success, failed);
        };
    }
})();
