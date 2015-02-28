var app = angular.module("qaApp", function(){});

app.service("questionService", ['$http',
	function($http) {
		var getQuestions = 
			function() {
			return $http({
				method: 'GET',
				url: "rs/question/all"
			});
		};

		return {
			getQuestions : getQuestions
		};
	}
]);

app.controller("qaController", ["$scope","questionService", function($scope, questionService) {
	$scope.questions = [];
	
	$scope.getQuestions = function() {
		questionService.getQuestions().then(function(result) {
			if (result) {
				$scope.questions = result.data;
			}
		});
	};	

}]);