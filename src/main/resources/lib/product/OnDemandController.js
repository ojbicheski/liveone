'use strict';

/* OnDemand Video Controller */

function OnDemandCtrl($scope, $http) {
	
	$scope.save = function(onDemand) {
		onDemand.id = $('#idOnDemand').val();
		$http.post('[#URL]/service/rest/product/ondemand/', onDemand).
			success(function(data, status) {
				alert(status);
				$('#onDemandModal').modal('hide');
				$scope.list();
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.list = function() {
		$http.get('[#URL]/service/rest/product/onDemand/').
			success(function(data, status) {
				if (data.result == null || data.result.length < 1) { return; }
				$scope.onDemands = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.get = function(id) {
		$http.get('[#URL]/service/rest/product/onDemand/' + id).
			success(function(data, status) {
				if (data.result == null) { return; }
				$('#onDemandModal').modal('show');
				$scope.onDemand = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.del = function(id) {
		$http.delete('[#URL]/service/rest/product/onDemand/' + id).
			success(function(data, status) {
				$scope.list();
				alert(status);
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.clean = function() {
		$scope.onDemand = null;
	};
	
}
