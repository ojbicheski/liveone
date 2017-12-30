'use strict';

/* Video Video Controller */

function VideoCtrl($scope, $http) {
	
	$scope.typeProduct = '-video';

	$scope.add = function(product) {
		$http.post('http://localhost:8180/livesales/service/rest/product/video/', product).
			success(function(data, status) {
				$('#video_id').val(data.result);
				$('#videoModal').modal('show');
			}).
			error(function(data, status) {
				alert(status);
			});
	};

	$scope.edit = function(product) {
		product.id = $('#video_id').val();
		$http.post('http://localhost:8180/livesales/service/rest/product/video/', product).
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
		$http.get('http://localhost:8180/livesales/service/rest/product/video/').
			success(function(data, status) {
				if (data.result == null || data.result.length < 1) {
					$scope.products = [];
					return; 
				}
				$scope.products = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.get = function(id) {
		$scope.clean();
		$http.get('http://localhost:8180/livesales/service/rest/product/video/' + id).
			success(function(data, status) {
				if (data.result == null) { return; }
				$('#videoModal').modal('show');
				$('#video_id').val(data.result.id);
				$scope.product = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.del = function(id) {
		$http.delete('http://localhost:8180/livesales/service/rest/product/video/' + id).
			success(function(data, status) {
				$scope.list();
				alert(status);
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.clean = function() {
		$scope.product = null;
	};
	
	$scope.gallery = function(id) {
		$('#galleryModal' + $scope.typeProduct).modal('show');
		$('#reference' + $scope.typeProduct).val(id);
		$scope.loadImages();
		
	};
	
	$scope.loadImages = function() {
		var ref = $('#reference' + $scope.typeProduct).val();
		$http.get('http://localhost:8180/livesales/service/rest/search/image/product/' + ref + '/gallery').
			success(function(data, status) {
				if (data.result == null || data.result.length < 1) {
					$scope.images = [];
					return; 
				}
				$scope.images = data.result;
			}).
			error(function(data, status) {
				alert(status);
			});
	}

	$scope.removeImage = function(id) {
		$http.delete('http://localhost:8180/livesales/service/rest/product/image/' + id).
		success(function(data, status) {
			$scope.loadImages();
		}).
		error(function(data, status) {
			alert(status);
		});
	};

	$scope.activateIcon = function(id) {
		var ref = $('#reference' + $scope.typeProduct).val();
		$http.get('http://localhost:8180/livesales/service/rest/product/image/' + id + '/icon/activate/' + ref).
			success(function(data, status) {
				$scope.loadImages();
			}).
			error(function(data, status) {
				alert(status);
			});
	};
	
	$scope.cleanGallery = function() {
		$('#reference' + $scope.typeProduct).val('');
		$('#file' + $scope.typeProduct).val('');
	};
}
