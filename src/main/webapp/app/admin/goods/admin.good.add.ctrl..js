/**
 * Created by Ivan on 29.03.2017.
 */
(function () {
    'use strict';

    angular
        .module('main')
        .controller('GoodEditCtrl', GoodEditCtrl);

    function GoodEditCtrl($scope, $state, GoodsService, TypesService, ManufacturersService, $location, ngDialog) {

        var sc = $scope;


        sc.saveGood = function (good, typeName, manufacturerName) {
            function success(response) {
            };

            function failed(response) {
            };

            GoodsService.saveGood(good, typeName, manufacturerName).then(success, failed);
        };
    }
})();
