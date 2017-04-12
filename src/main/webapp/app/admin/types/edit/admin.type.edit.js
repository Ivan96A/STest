(function () {
    'use strict';

    angular
        .module('main')
        .controller('TypeEditCtrl', TypeEditCtrl);

    function TypeEditCtrl($scope, $state, TypesService, $stateParams) {

        var sc = $scope;
        sc.typeId = $stateParams.typeId;

        sc.updateType = function (type) {
            function success(response) {
                $state.go('main.admin.types');
            };

            function failed(response) {
            };

            TypesService.update(type).then(success, failed);
        };

        sc.getOne = function (id) {
            function success(response) {
                sc.type = response.data;
            };

            function failed(response) {
                sc.type = response.data;
            };

            TypesService.getOneById(id).then(success, failed);
        };
    }
})();
