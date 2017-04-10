/**
 * Created by Ivan on 03.04.2017.
 */

(function () {
    'use strict';

    angular
        .module('goods', [
            'ui.router'
        ])
        .config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];
    function configure($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('main.admin.goods', {
                url: 'goods',
                controller: 'GoodsCtrl',
                templateUrl: 'app/admin/goods/admin.goods.view.html',
            })
            .state('main.admin.goodAdd', {
                    url: 'goodAdd',
                    controller: 'GoodEditCtrl',
                    templateUrl: 'app/admin/goods/good.add.view.html',
                }
            )
            .state('main.admin.goodEdit', {
                url: 'goodEdit/:goodId',
                controller: 'GoodEditCtrl',
                templateUrl: 'app/admin/goods/edit/admin.good.edit.view.html'
            });
    }

})();

