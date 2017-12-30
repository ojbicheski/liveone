'use strict';

/* Phone Controller */
function PhoneCtrl($scope, $http) {
	
	$scope.save = function(phone) {
		var id = $('#id').val();
		$http.post('[#URL]/service/rest/member/' + id +'/phone/', phone).
			success(function(data, status) {
				alert(status);
				$('#phoneModal').modal('hide');
				$scope.list();
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.list = function() {
		var id = $('#id').val();
		$http.get('[#URL]/service/rest/member/' + id +'/phones/').
			success(function(data, status) {
				if (data.result == null || data.result.length < 1) { return; }
				$scope.phones = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.get = function(idPhone) {
		var id = $('#id').val();
		$http.get('[#URL]/service/rest/member/' + id +'/phone/' + idPhone).
			success(function(data, status) {
				if (data.result == null) { return; }
				$('#phoneModal').modal('show');
				$scope.phone = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.del = function(idPhone) {
		var id = $('#id').val();
		$http.delete('[#URL]/service/rest/member/' + id +'/phone/' + idPhone).
			success(function(data, status) {
				$scope.list();
				alert(status);
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.clean = function() {
		$scope.phone = null;
	};
}