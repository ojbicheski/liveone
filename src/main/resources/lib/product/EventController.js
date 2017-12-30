'use strict';

/* Event Controller */

function EventCtrl($scope, $http) {
	
	$scope.save = function(event) {
		event.id = $('#idEvent').val();
		$http.post('[#URL]/service/rest/product/event/', event).
			success(function(data, status) {
				//$scope.data = data;
				alert(status);
				$('#eventModal').modal('hide');
				$scope.list();
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.list = function() {
		$http.get('[#URL]/service/rest/product/event/').
			success(function(data, status) {
				if (data.result == null || data.result.length < 1) { return; }
				$scope.events = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.get = function(id) {
		$http.get('[#URL]/service/rest/product/event/' + id).
			success(function(data, status) {
				if (data.result == null) { return; }
				$('#eventModal').modal('show');
				$scope.event = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.del = function(id) {
		$http.delete('[#URL]/service/rest/product/event/' + id).
			success(function(data, status) {
				$scope.list();
				alert(status);
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.clean = function() {
		$scope.event = null;
	};
	
}
