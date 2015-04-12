'use strict';


angular.module('fibserverApp')
.factory('FibService', function ($http) {
    return {
        findAll: function (input) {
//        	$scope.fibResult = [];
//        	$http.post("api/fibonacci", input)
//	        	.success(function(data, status, headers, config) {
//	        		$scope.fibResult = data;
//	        		alert('data');
//	        	}).error(function(data, status, headers, config) {
//	        		$scope.status = status;
//	        		alert('error '+ data + status + headers + config);
//        	});
        	
//        	$http.post('api/fibonacci',input).success(function (response) {
//        		alert(response);
//        		alert(response.data);
//                return response.data;
//            });
        },
        
    };
});

