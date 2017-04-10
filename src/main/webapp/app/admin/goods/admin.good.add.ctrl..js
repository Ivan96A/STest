/**
 * Created by Ivan on 29.03.2017.
 */
(function () {
    'use strict';

    angular
        .module('main')
        .controller('GoodEditCtrl', GoodEditCtrl);

    function GoodEditCtrl($scope, $stateParams, GoodsService) {

        var sc = $scope;

        sc.goodId = $stateParams.goodId;

        sc.saveGood = function (good, typeName, manufacturerName) {
            function success(response) {
            };

            function failed(response) {
            };

            GoodsService.saveGood(good, typeName, manufacturerName).then(success, failed);
        };

        sc.getOne = function(id) {
            function success(response) {
                sc.good = response.data;
            };

            function failed(response) {
                sc.good = response.data;
            };

            GoodsService.getById(id).then(success, failed);
        };

        sc.updateGood = function(good, typeName, manufacturerName) {
            function success(response) {
                sc.good = response.data;
            };

            function failed(response) {
                sc.good = response.data;
            };

            GoodsService.update(good, typeName, manufacturerName).then(success, failed);
        }
    }
})();
