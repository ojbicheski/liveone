'use strict';

/* Type Video Controller */

function TypeVideoCtrl($scope, $http) {
	
	$scope.loadTypes = function() {
		$http.get('http://localhost:8180/livesales/service/rest/typeVideo/').
			success(function(data, status) {
				if (data.result == null || data.result.length < 1) { return; }
				$scope.types = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
}
