<html>
<body>
	<div id="errormsg" style="display: none"></div>
	<div>
		<form method="POST" action="${contextPath}/login" class="form-signin">
			<h2 class="form-heading">Change Password</h2>

			<div class="form-group ${error != null ? 'has-error' : ''}">
				<input name="password" type="password" class="form-control"
					placeholder="Password" /> <input name="password" type="password"
					class="form-control" placeholder="confirmPassword" /> <span>${error}</span>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</div>
			<span id="error" style="display: none">Password mismatch</span>

			<h4 class="text-center">
				<a href="${contextPath}/resetPassword">Update Password</a>
			</h4>
		</form>
	</div>

	<script src="jquery.min.js"></script>

</body>
</html>