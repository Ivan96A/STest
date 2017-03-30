/**
 * Created by Ivan on 29.03.2017.
 */
(function () {
    'use strict';

    angular
        .module('main')
        .controller('GoodsCtrl', GoodsCtrl);

    function GoodsCtrl($scope, $state, GoodsService, $location, ngDialog) {

        var sc = $scope;

        sc.getGoods = function (goodName, typeId) {
            if(goodName == "") goodName = null;
             if(typeId== "All") typeId = null;

            function success(response) {
                sc.goods = response.data;
            };

            function failed(response) {
                sc.goods = response.data;
            };

            GoodsService.getAll(goodName, typeId).then(success, failed);
        }
    }
})();