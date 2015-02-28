<!DOCTYPE html>
<html ng-app="qaApp">
<head>
<title>Q&A App</title>

<!-- angular-js -->
<script src="js/angular.min.js"></script>
<script src="js/qa.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/ui-bootstrap-tpls-0.12.1.min.js"></script>


<link rel="stylesheet" href="css/qa.css">
</head>
<body>

	<div class="container-fluid" ng-controller="qaController">

		<div class="body drop-shadow">
			<ul class="table-row">
				<div class="row">
					<span class="col-xs-2 text-primary">Titre</span> <span
						class="col-xs-5 text-primary">Détail</span> <span
						class="col-xs-4 text-primary">Utilisateur</span> <span
						class="col-xs-1">&nbsp;</span>
				</div>
			</ul>
			<div class="body-data">
				<ul ng-repeat="question in questions" class="table-row">
					<div class="row">
						<span class="col-xs-2 text-info">{{ question.title }}</span> <span
							class="col-xs-5 text-info">{{ question.description }}</span> <span
							class="col-xs-4 text-info">{{ question.userid }}</span> <span
							class="col-xs-1"> </span>
					</div>
				</ul>
			</div>

		</div>
	</div>
</body>
</html>