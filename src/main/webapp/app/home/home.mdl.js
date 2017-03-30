/**
 * Created by Ivan on 28.03.2017.
 */
(function () {
    'use strict';

    angular
        .module('home', [
            'ui.router'
        ])
        .config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];
    function configure($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('main.home', {
                url: '',
                controller: 'GoodsCtrl',
                templateUrl: 'app/home/home.view.html'
            })
            .state('main.good',{
               url: 'good/:goodId',
                controller: 'GoodsEditCtrl',
                templateUrl: 'app/good/profile/good.profile.view.html'
            });

    }

})();