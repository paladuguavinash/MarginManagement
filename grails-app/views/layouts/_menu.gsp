<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<sec:ifAllGranted roles="ROLE_ADMIN">
			<li class="active"><g:link controller="admin" action="index">Create Users</g:link></li>
		</sec:ifAllGranted>
		<g:if test="${loggedInUser.type != 'test'}">
			<li class="active"><a href="#"> ${type.name} <b>(${loggedInUser.type})</b>
			</a>
				<ul>
					<g:each in="${results}" var="r">
						<g:each in="${r}" var="rsm">
							<li>
								<a href="#">${rsm.name}</a>
								<ul>
									<g:each in="${rsm.customers}" var="customer">
										<li>
											<a href="#">${customer.name}</a>
										</li>
									</g:each>
									<g:each in="${r.mas}" var="ma">
										<li>
											<a href="#">${ma.name}</a>
										</li>
									</g:each>
								</ul>
								<ul>
									<g:each in="${r.dsms}" var="dsm">
										<li>
											<a href="#">${dsm.name}</a>
											<ul>
												<g:each in="${dsm.mas}" var="ma">
													<li>
														<a href="#">${ma.name}</a>
														<ul>
															<g:each in="${ma.customers}" var="customer">
																<li>
																	<a href="#">${customer.name}</a>
																</li>
															</g:each>
														</ul>
													</li>
												</g:each>
											</ul>
										</li>
									</g:each>
								</ul>
							</li>
						</g:each>
					</g:each>
				</ul></li>
		</g:if>
	</ul>
</div>


