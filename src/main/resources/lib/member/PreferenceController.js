'use strict';

/* Preference Controller */

function PreferenceCtrl($scope, $http) {
	$scope.list = function() {
		$http.get('[#URL]/service/rest/search/typePreference/preferences/').
		success(function(data, status) {
			if (data.result == null || data.result.length < 1) { return; }
			$('#listPreferences div').remove();
			$.each(data.result, function(index1, type) {
				$('#listPreferences').append('<label class="col-lg-12">'+type.description+'</label>'); 
				$.each(type.preferences, function(index2, preference) {
					$('#listPreferences').append(
						'<div class="col-lg-4">'+
						'  <div class="input-group">'+
						'    <span class="input-group-addon">'+
						'      <input type="checkbox" id="preferences" value="'+preference.id+'">'+
						'    </span>'+
						'    <span class="form-control">'+preference.description+'</span>'+
						'  </div>'+
						'</div>');
				});
			});
		}).
		error(function(data, status) {
			//$scope.data = data || "Request failed";
			alert(status);
		});
	};
}
