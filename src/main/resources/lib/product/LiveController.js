'use strict';

/* Live Video Controller */

function LiveCtrl($scope, $http) {
	
	$scope.add = function(live) {
		$http.post('[#URL]/service/rest/product/live/', live).
			success(function(data, status) {
				$('#idLive').val(data.result);
				$('#liveModal').modal('show');
			}).
			error(function(data, status) {
				alert(status);
			});
	};

	$scope.edit = function(live) {
		live.id = $('#idLive').val();
		alert($('#liveUnpublish').val());
		$http.post('[#URL]/service/rest/product/live/', live).
			success(function(data, status) {
				$('#liveModal').modal('hide');
				$scope.clean();
				$scope.list();
				alert(status);
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.list = function() {
		$http.get('[#URL]/service/rest/product/live/').
			success(function(data, status) {
				if (data.result == null || data.result.length < 1) { return; }
				$scope.lives = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.get = function(id) {
		$scope.clean();
		$http.get('[#URL]/service/rest/product/live/' + id).
			success(function(data, status) {
				if (data.result == null) { return; }
				$('#liveModal').modal('show');
				$('#idLive').val(data.result.id);
				$scope.live = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.del = function(id) {
		$http.delete('[#URL]/service/rest/product/live/' + id).
			success(function(data, status) {
				$scope.list();
				alert(status);
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.clean = function() {
		$scope.live = null;
	};
	
}
