/**
 * Created by Ivan on 08.04.2017.
 */

(function () {
    'use strict';

    angular
        .module('main')
        .controller('TypeAddCtrl', TypeAddCtrl);

    function TypeAddCtrl($scope, TypesService) {

        var sc = $scope;

        sc.saveType= function (type) {
            function success(response) {
            };

            function failed(response) {
            };

            TypesService.save(type).then(success, failed);
        };
    }
})();
