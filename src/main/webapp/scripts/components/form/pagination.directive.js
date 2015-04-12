/* globals $ */
'use strict';

angular.module('fibserverApp')
    .directive('fibserverAppPagination', function() {
        return {
            templateUrl: 'scripts/components/form/pagination.html'
        };
    });
