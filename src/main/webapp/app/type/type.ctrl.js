(function () {
    'use strict';

    angular
        .module('main')
        .controller('TypesCtrl', TypesCtrl);

    function TypesCtrl($scope, $state, TypesService, $location, ngDialog) {

        var sc = $scope;

        sc.getTypes = function () {

            function success(response) {
                sc.types = response.data;
            };

            function failed(response) {
                sc.types = response.data;
                console.log(response.status);
            };

            TypesService.getAll().then(success, failed);
        };

        sc.getTypeByName = function (name) {

            function success(response) {
                sc.type = response.data;
            };

            function failed(response) {
                sc.type = response.data;
                console.log(response.status);
            };

            TypesService.getOneByName(name).then(success, failed);
        };
    }
})();
