(function () {
    'use strict';

    angular
        .module('admin', [
            'users',
            'manufacturers',
            'types',
            'goods',
            'ui.router'
        ])
        .config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];
    function configure($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('main.admin', {
                url: 'admin/',
                templateUrl: 'app/admin/admin.view.html',
                data: {
                    is_granted: ["ROLE_ADMIN"]
                }
            });
    }

})();

