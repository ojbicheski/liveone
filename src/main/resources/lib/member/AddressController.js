'use strict';

/* Address Controller */
function AddressCtrl($scope, $http) {
	
	$scope.save = function(address) {
		var id = $('#id').val();
		$http.post('[#URL]/service/rest/member/' + id +'/address/', address).
			success(function(data, status) {
				//$scope.data = data;
				alert(status);
				$('#addressModal').modal('hide');
				$scope.list();
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.list = function() {
		var id = $('#id').val();
		$http.get('[#URL]/service/rest/member/' + id +'/addresses/').
			success(function(data, status) {
				if (data.result == null || data.result.length < 1) { return; }
				$scope.addresses = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.get = function(idAddress) {
		var id = $('#id').val();
		$http.get('[#URL]/service/rest/member/' + id +'/address/' + idAddress).
			success(function(data, status) {
				if (data.result == null) { return; }
				$('#addressModal').modal('show');
				$scope.address = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.del = function(idAddress) {
		var id = $('#id').val();
		$http.delete('[#URL]/service/rest/member/' + id +'/address/' + idAddress).
			success(function(data, status) {
				$scope.list();
				alert(status);
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.clean = function() {
		$scope.address = null;
	};
}