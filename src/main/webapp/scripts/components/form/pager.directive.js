/* globals $ */
'use strict';

angular.module('fibserverApp')
    .directive('fibserverAppPager', function() {
        return {
            templateUrl: 'scripts/components/form/pager.html'
        };
    });
