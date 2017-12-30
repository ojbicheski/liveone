'use strict';

/* Offering Controller */

function OfferingCtrl($scope, $http) {
	
	$scope.add = function(offering) {
		$http.post('http://localhost:8180/livesales/service/rest/sales/offering/', offering).
			success(function(data, status) {
				$('#video_id').val(data.result);
				$('#videoModal').modal('show');
			}).
			error(function(data, status) {
				alert(status);
			});
	};

	$scope.edit = function(offering) {
		offering.id = $('#video_id').val();
		$http.post('http://localhost:8180/livesales/service/rest/sales/offering/', offering).
			success(function(data, status) {
				$('#videoModal').modal('hide');
				$scope.clean();
				$scope.list();
				alert(status);
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.list = function() {
		$http.get('http://localhost:8180/livesales/service/rest/sales/offering/').
			success(function(data, status) {
				if (data.result == null || data.result.length < 1) {
					$scope.offerings = [];
					return; 
				}
				$scope.offerings = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.get = function(id) {
		$scope.clean();
		$http.get('http://localhost:8180/livesales/service/rest/sales/offering/' + id).
			success(function(data, status) {
				if (data.result == null) { return; }
				$('#videoModal').modal('show');
				$('#video_id').val(data.result.id);
				$scope.offering = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.del = function(id) {
		$http.delete('http://localhost:8180/livesales/service/rest/sales/offering/' + id).
			success(function(data, status) {
				$scope.list();
				alert(status);
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.clean = function() {
		$scope.offering = null;
	};
}
