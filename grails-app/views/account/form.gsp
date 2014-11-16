<meta name="layout" content="main" />

<g:form controller="admin" action="createUser" name="_createUser"
	class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-2 control-label">User Type:</label>
		<div class="col-sm-5">
			<g:select from="${['BSM','RSM','DSM','MA','CUSTOMER']}" name="atype"
				noSelection="${['':'Select...']}" class="form-control"  required="true"
				onchange="change(this.value);${remoteFunction(controller:'admin', action:'populateUsers', params:'\'type=\' + this.value', onSuccess: 'populateUsers(data)')}" />
		</div>
	</div>
	<div class="form-group assoType" style="display: none">
		<label class="col-sm-2 control-label">Associate Type:</label>
		<div class="col-sm-5">
			<g:select from="${[]}" id="associateType" name="associateType"
				noSelection="${['':'Select...']}" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-8">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Name</th>
					<th>Code</th>
				</tr>
				<g:each in="${1..<4}" var="b" status="i">
					<tr>
						<td><g:textField name="bsms[${i}].name"
								placeholder="name ${i+1}" class="as_tp form-control" required="true"/></td>
						<td><g:textField name="bsms[${i}].code"
								placeholder="code ${i+1}" class="as_tp form-control" required="true"/></td>
					</tr>
				</g:each>
			</table>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<g:submitButton name="Save" value="Save"
				class="btn btn-primary btn-lg" />
		</div>
	</div>
</g:form>
<script>
function change(value){
	if(value != 'BSM'){
		$('.assoType').show();
	} else{
		$('.assoType').hide();
	}
}
function populateUsers(data){
	var element = $('#associateType').empty();
	$(element).append($('<option/>').val('').text('Select...'));
	console.log(data)
	$.each(data, function(key, value) {
		$('.as_tp').each(function(){
			var self = this
			var id = $(self).attr("id");
			var c = id.substring(0);
			var n = $(self).attr("id");
			if(value == 'RSM'){
				c = 'r'
				n = c + id.substring(1, id.length)
			}
			if(value == 'DSM'){
				c = 'd'
				n = c + id.substring(1, id.length)
			}
			if(value == 'MA'){
				c = 'ma'
				n = c + id.substring(3, id.length)
			}
			if(value == 'CUSTOMER'){
				c = 'customer'
				n = c + id.substring(3, id.length)
			}
			$(self).attr("name", n)
		});
		
		var option = $('<option/>').val(value.id).text(value.name);
		$(element).append(option)
	});
}
</script>