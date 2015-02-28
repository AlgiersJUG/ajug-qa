var app = angular.module("qaApp", function() {});

app.controller("qaController", [ "$scope","$http",
		function($scope,$http) {
		$scope.test=10;
			$scope.questions = [];
			$http.get("/ajug-qa/rs/question/all").
				success(function(data) {
					$scope.questions = data;
				}
			);
} ]);
