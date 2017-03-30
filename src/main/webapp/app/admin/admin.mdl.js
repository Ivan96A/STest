(function () {
    'use strict';

    angular
        .module('admin', [
            'ui.router'
        ])
        .config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];
    function configure($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('main.admin', {
                url: 'admin',
                //controller: 'LoginCtrl',
                templateUrl: 'app/admin/admin.view.html',
                data: {
                    is_granted: ["ROLE_ADMIN"]
                }
            });
    }

})();

