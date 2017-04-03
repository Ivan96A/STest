(function () {
    'use strict';

    angular
        .module('main')
        .controller('OrdersCtrl', OrdersCtrl);

    function OrdersCtrl($scope, $state, GoodsService, $location, ngDialog, $rootScope) {

        var sc = $scope;
        sc.username = $rootScope.globals.currentUser.username;

        sc.sentData = {
            'goodId': '',
            'username': ''
        };

        sc.sentData.username = $rootScope.globals.currentUser.username;


        sc.getOrderByUsername = function () {

            function success(response) {
                sc.goodDTO = response.data;
            };

            function failed(response) {
                sc.goodDTO = response.data;
            };

            GoodsService.getGoodsByUsername(sc.username).then(success, failed);
        };

        sc.deleteGoodFromOrder = function(id) {
             sc.sentData.goodId = id;
            function success(response) {

            };

            function failed(response) {

            };

            GoodsService.deleteGoodFromOrder(sc.sentData).then(success, failed);
        };
    }
})();