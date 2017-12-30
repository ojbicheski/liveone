'use strict';

/* Member Controller */

function MemberCtrl($scope, $http) {
	
	$scope.save = function(member) {
		member.id = $('#id').val();
		$('#preferences:checked').each(function() {
			member.preferences.push({ id: $(this).val() });
		});
		$http.post('[#URL]/service/rest/member/', member).
			success(function(data, status) {
				//$scope.data = data;
				alert(status);
			}).
			error(function(data, status) {
				//$scope.data = data || "Request failed";
				alert(status);
			});
	};

	$scope.get = function() {
		var id = $('#id').val();
		$http.get('[#URL]/service/rest/member/' + id).
		success(function(data, status) {
			if (data.result == null) { return; }
			$scope.member = data.result;
			$.each(data.result.preferences, function(index, preference) {
				$('#preferences:input[value=' + preference.id + ']').attr('checked',true);
			});
		}).
		error(function(data, status) {
			alert(status);
		});
	};

	$scope.del = function() {
		
	};
}
