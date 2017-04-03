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
                url: 'admin.goods',
                //controller: 'LoginCtrl',
                templateUrl: 'app/admin/goods/admin.goods.view.html',
            });
    }

})();

