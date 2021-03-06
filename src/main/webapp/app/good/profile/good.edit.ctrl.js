/**
 * Created by Ivan on 30.03.2017.
 */
(function () {
    'use strict';

    angular
        .module('main')
        .controller('GoodsEditCtrl', GoodsEditCtrl);

    function GoodsEditCtrl($scope, $stateParams, GoodsService, $location, $rootScope) {
        var sc = $scope;

        sc.goodId = $stateParams.goodId;

        sc.sentData = {
            'goodId': '',
            'username': ''
        };

        sc.sentData.username = $rootScope.globals.currentUser.username;


        sc.getGoodById = function(id) {

            function success(response) {
                sc.good = response.data;
                //sc.gameName = sc.game.name;
            }

            function failed(response) {
                sc.good = response.data;
            }

            GoodsService.getById(id).then(success, failed);

        };

        sc.addGoodToOrder = function () {
            sc.sentData.goodId = sc.goodId;
            function success(response) {

            };

            function failed(response) {

            };

            GoodsService.addGoodToOrder(sc.sentData).then(success, failed);
        };


    }
})();